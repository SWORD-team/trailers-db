package com.sword.trailersdb.controllers;

import com.sword.trailersdb.data.models.MovieModel;
import com.sword.trailersdb.exceptions.ElementNotFoundException;
import com.sword.trailersdb.repositories.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class MovieController {

    // TODO: Refactor to services
    private final MovieRepository repository;
    MovieController(MovieRepository repository) {
        this.repository = repository;
    }

    //GET ALL
    @GetMapping("/movies")
    List<MovieModel> all() {
        return repository.findAll();
    }


    //POST
    @PostMapping("/movies")
    MovieModel newMovie(@RequestBody MovieModel newMovie) {
        return repository.save(newMovie);
    }

    //GET 1
    // Single item
    @GetMapping("/movies/{id}")
    MovieModel one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException("", id));
    }

    //PUT
    @PutMapping("/movies/{id}")
    MovieModel replaceMovie(@RequestBody MovieModel newMovie, @PathVariable Long id) {

        return newMovie;
    }

    //DELETE
    @DeleteMapping("/movies/{id}")
    void deleteMovie(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
