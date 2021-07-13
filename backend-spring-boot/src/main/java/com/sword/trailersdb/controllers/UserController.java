package com.sword.trailersdb.controllers;

import com.sword.trailersdb.dtos.InputUserDto;
import com.sword.trailersdb.dtos.UserDto;
import com.sword.trailersdb.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/api/v1/users/{id}")
    ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getUser(id));
    }

    @PutMapping("/api/v1/users/{id}")
    ResponseEntity<UserDto> editUser(@RequestBody InputUserDto editedUser, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.modifyUser(id, editedUser));
    }

}
