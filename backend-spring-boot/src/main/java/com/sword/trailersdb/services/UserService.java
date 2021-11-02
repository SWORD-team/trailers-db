package com.sword.trailersdb.services;

import com.sword.trailersdb.data.dtos.user.InputUserDto;
import com.sword.trailersdb.data.dtos.user.UserDto;
import com.sword.trailersdb.exceptions.ElementNotFoundException;
import com.sword.trailersdb.data.mappers.UserMapper;
import com.sword.trailersdb.data.models.UserModel;
import com.sword.trailersdb.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;


    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // Achieves user from db and raises exception
    public UserModel getUserFromRepo(Long id) {
        return repository.findById(id).orElseThrow(() -> new ElementNotFoundException("user", id));
    }

    // Get user's dto
    public UserDto getUser(Long id) {
        return mapper.toDto(this.getUserFromRepo(id));
    }

    public UserModel getUserByEmail(String email) {
        try {
            return repository.findByEmail(email).get();
        } catch (Exception e) {
            return null;
        }
    }

    public UserDto modifyUser(Long id, InputUserDto editedUserDto) {

        // Fetch user by id
        UserModel userFromDb = this.getUserFromRepo(id);
        // Replace dto data in user instance
        mapper.updateUserFromDto(editedUserDto, userFromDb);
        repository.save(userFromDb);
        return mapper.toDto(userFromDb);
    }


    public UserDto createUser(InputUserDto editedUserDto){
        if (repository.findByEmail(editedUserDto.getEmail()).isPresent()){
            return new UserDto();
        } else {
            UserModel newUser = new UserModel();
            newUser.setName(editedUserDto.getName());
            newUser.setEmail(editedUserDto.getEmail());
            newUser.setPassword(new BCryptPasswordEncoder().encode(editedUserDto.getPassword()));
            return mapper.toDto(repository.save(newUser));
        }
    }

}
