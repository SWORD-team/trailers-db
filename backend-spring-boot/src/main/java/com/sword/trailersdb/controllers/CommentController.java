package com.sword.trailersdb.controllers;

import com.sword.trailersdb.data.models.CommentModel;
import com.sword.trailersdb.exceptions.ElementNotFoundException;
import com.sword.trailersdb.repositories.CommentRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController//@RestController indicates that the data returned by each method will be written straight into the
// response body instead of rendering a template.
class CommentController {
    // TODO: Refactor to services
    private final CommentRepository repository;
    CommentController(CommentRepository repository) {
        this.repository = repository;
    }

    // GET ALL
    @GetMapping("/comments")
    List<CommentModel> all() {
        return repository.findAll();
    }

    // GET Single item
    @GetMapping("/comments/{id}")
    CommentModel one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ElementNotFoundException("", id));}

    //POST
    @PostMapping("/comments")
    CommentModel newComment(@RequestBody CommentModel newComment) {
        return repository.save(newComment);
    }

    //PUT
    @PutMapping("/comments/{id}")
    CommentModel replaceComment(@RequestBody CommentModel newComment, @PathVariable Long id) {
        return repository.findById(id).
                map(comment -> {
                    comment.setText(newComment.getText());
                    comment.setDatePosted(newComment.getDatePosted());
                    comment.setRating(newComment.getRating());
                    return repository.save(comment);
                }).orElseGet(() -> {
            newComment.setId(id);
            return repository.save(newComment);
        });
    }

    //DELETE
    @DeleteMapping("/movies/{id}")
    void deleteComment(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
