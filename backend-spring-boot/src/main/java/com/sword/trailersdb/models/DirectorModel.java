package com.sword.trailersdb.models;

import java.util.Objects;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Struct;

@Entity(name = "Director")
public class DirectorModel {
    private @Id @GeneratedValue Long id;
    private String name;
    //private ArrayList<Movie> movies;
    /* Actor() {}
    Actor(String name) {
        this.name = name;
    } */
    public Long getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    //public ArrayList getMovies(){        return this.movies;    }

    public void setId(Long id){
        this.id = id;
    }
    public void setName(){
        this.name = name;
    }
    //public  void addMovie() {this.movies = movies;}
}