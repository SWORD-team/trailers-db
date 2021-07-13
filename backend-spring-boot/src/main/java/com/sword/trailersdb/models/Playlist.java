package src.main.java.com.sword.trailersdb.models;

import java.util.ArrayList;

public class Playlist {

    int id;
    ArrayList<com.sword.trailersdb.Movie> movies = new ArrayList<>();

    public void addMovie(com.sword.trailersdb.Movie movie) {
        movies.add(movie);
    }

    public void deleteMovie(com.sword.trailersdb.Movie movie) {
        movies.remove(movie);
    }

    public void deleteListMovie() {
        movies.clear();
    }
}
