package com.sword.trailersdb.data.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity(name = "Actor")
public class ActorModel {
    private @Id @GeneratedValue Long id;
    private String name;
    private List<MovieModel> movies;


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
    public List<MovieModel> getMovies() {
        return movies;
    }
    //public void addMovies(ArrayList<MovieModel> movies) {this.movies = movies;}

}