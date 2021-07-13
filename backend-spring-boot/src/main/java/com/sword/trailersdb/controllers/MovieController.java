package com.sword.trailersdb.controllers;

import com.sword.trailersdb.exceptions.MovieNotFoundException;
import com.sword.trailersdb.models.Movie;
import com.sword.trailersdb.repositories.MovieRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    private final MovieRepository repository;
    MovieController(MovieRepository repository) {
        this.repository = repository;
    }

    //GET ALL
    @GetMapping("/Movies")
    List<com.sword.trailersdb.models.Movie> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    //POST
    @PostMapping("/Movies")
    com.sword.trailersdb.models.Movie newMovie(@RequestBody com.sword.trailersdb.models.Movie newMovie) {
        return repository.save(newMovie);
    }

    //GET 1
    // Single item
    @GetMapping("/Movies/{id}")
    com.sword.trailersdb.models.Movie one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    //PUT
    @PutMapping("/Movies/{id}")
    com.sword.trailersdb.models.Movie replaceMovie(@RequestBody com.sword.trailersdb.models.Movie newMovie, @PathVariable Long
            id) {
        return repository.findById(id)
                .map(Movie -> {
                    Movie.setName(newMovie.getName());
                    // Movie.setMovies(newMovie.getMovies());
                    return repository.save(Movie);
                })
                .orElseGet(() -> {
                    newMovie.setId(id);
                    return repository.save(newMovie);
                });
    }

    //DELETE
    @DeleteMapping("/Movies/{id}")
    void deleteMovie(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
