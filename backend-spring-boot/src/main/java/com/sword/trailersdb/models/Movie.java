package com.sword.trailersdb;

import src.main.java.com.sword.trailersdb.models.Enums;

import java.util.ArrayList;
import java.util.Date;

public class Movie {

    int id;
    String title;
    String trailer;
    String image;
    Lenguage lenguage;
    Lenguage subtitle;
    String duration;
    String description;
    Date releaseDate;
    boolean sfa;
    Genre genre;
    ArrayList<Director> directors;
    ArrayList<Actor> actors;
    float rating;
    int displays;
    ArrayList<Comment> comments;


    public Movie(int id, String title, String trailer, String image, Lenguage lenguage, Lenguage subtitle, String duration, String description, Date releaseDate, boolean sfa, Genre genre, ArrayList<Director> directors, ArrayList<Actor> actors, float rating, int displays, ArrayList<Comment> comments) {
        this.id = id;
        this.title = title;
        this.trailer = trailer;
        this.image = image;
        this.lenguage = lenguage;
        this.subtitle = subtitle;
        this.duration = duration;
        this.description = description;
        this.releaseDate = releaseDate;
        this.sfa = sfa;
        this.genre = genre;
        this.directors = directors;
        this.actors = actors;
        this.rating = rating;
        this.displays = displays;
        this.comments = comments;
    }

    public String showInfoMovie(int id){
        String info = "";
        return info;
    }

    public void editMovie(int id){

    }

    public boolean deleteMovie(int id){
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Lenguage getLenguage() {
        return lenguage;
    }

    public void setLenguage(Lenguage lenguage) {
        this.lenguage = lenguage;
    }

    public Lenguage getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(Lenguage subtitle) {
        this.subtitle = subtitle;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isSfa() {
        return sfa;
    }

    public void setSfa(boolean sfa) {
        this.sfa = sfa;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public ArrayList<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(ArrayList<Director> directors) {
        this.directors = directors;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getDisplays() {
        return displays;
    }

    public void setDisplays(int displays) {
        this.displays = displays;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}
