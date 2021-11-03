package com.sword.trailersdb.controllers;

import com.sword.trailersdb.data.dtos.user.InputUserDto;
import com.sword.trailersdb.data.dtos.user.UserDto;
import com.sword.trailersdb.data.models.UserModel;
import com.sword.trailersdb.services.UserService;
import com.sword.trailersdb.utilities.constants.Endpoints;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(Endpoints.SPECIFIC_USERS)
    ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getUser(id));
    }

    @PutMapping(Endpoints.SPECIFIC_USERS)
    ResponseEntity<UserDto> editUser(@RequestBody InputUserDto editedUser, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.modifyUser(id, editedUser));
    }

    @PostMapping("/register")
    ResponseEntity<String> register(@RequestBody InputUserDto editedUser) {
        UserModel user = service.getUserByEmail(editedUser.getEmail());
        if (user != null){
            return new ResponseEntity<String>("User already exists", HttpStatus.BAD_REQUEST);
        } else {
            service.createUser(editedUser);
            return new ResponseEntity<String>("User created", HttpStatus.OK);
        }
    }

    @CrossOrigin(origins="*")
    @PostMapping("/login")
    HttpEntity<? extends Serializable> login(@RequestBody InputUserDto editedUser) {

        UserModel user = service.getUserByEmail(editedUser.getEmail());
        if (user != null){
            if (new BCryptPasswordEncoder().matches(editedUser.getPassword(), user.getPassword())){
                String token = getJWTToken(user.getEmail());
                HashMap<String, String> map = new HashMap<>();
                map.put("token", token);
                return new ResponseEntity<HashMap>(map, HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Incorrect password", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<String>("User not exists", HttpStatus.BAD_REQUEST);
        }

    }




    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return token;
    }

}
