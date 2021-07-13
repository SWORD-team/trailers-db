package com.sword.trailersdb.services;

import com.sword.trailersdb.dtos.InputUserDto;
import com.sword.trailersdb.dtos.UserDto;
import com.sword.trailersdb.exceptions.ElementNotFoundException;
import com.sword.trailersdb.mappers.UserMapper;
import com.sword.trailersdb.models.UserModel;
import com.sword.trailersdb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException("user", id));
    }

    // Get user's dto
    public UserDto getUser(Long id) {
        return mapper.toDto(this.getUserFromRepo(id));
    }

    public UserDto modifyUser(Long id, InputUserDto editedUserDto) {

        // Fetch user by id
        UserModel userFromDb = this.getUserFromRepo(id);
        // Replace dto data in user instance
        mapper.updateUserFromDto(editedUserDto, userFromDb);
        repository.save(userFromDb);
        return mapper.toDto(userFromDb);
    }



}
