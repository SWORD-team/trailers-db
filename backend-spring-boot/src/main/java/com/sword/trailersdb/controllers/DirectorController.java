package com.sword.trailersdb.controllers;

import com.sword.trailersdb.data.models.DirectorModel;
import com.sword.trailersdb.repositories.DirectorRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController   //@RestController indicates that the data returned by each method will be written straight into the response body instead of rendering a template.
class DirectorController {

    // TODO: Refactor to services
    private final DirectorRepository repository;
    DirectorController(DirectorRepository repository) {
        this.repository = repository;
    }

    //GET ALL
    @GetMapping("/directors")
    List<Director> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    //POST
    @PostMapping("/directors")
    Director newDirector(@RequestBody Director newDirector) {
        return repository.save(newDirector);
    }

    //GET 1
    // Single item
    @GetMapping("/directors/{id}")
    Director one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new DirectorNotFoundException(id));
    }

    //PUT
    @PutMapping("/directors/{id}")
    Director replaceDirector(@RequestBody Director newDirector, @PathVariable Long
            id) {
        return repository.findById(id)
                .map(director -> {
                    director.setName(newActor.getName());
                    // director.setMovies(newActor.getMovies());
                    return repository.save(director);
                })
                .orElseGet(() -> {
                    newDirector.setId(id);
                    return repository.save(newDirector);
                });
    }

    //DELETE
    @DeleteMapping("/directors/{id}")
    void deleteDirector(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
