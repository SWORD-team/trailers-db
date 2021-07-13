package com.sword.trailersdb.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Actor")
public class ActorModel {
    private @Id @GeneratedValue Long id;
    private String name;
    //private ArrayList<Movie> movies;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }


}