package com.sword.trailersdb.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Size;

public class UserDto {

    private Integer id;
    private String email;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}