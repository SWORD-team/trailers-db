package com.sword.trailersdb.repositories;

import com.sword.trailersdb.data.models.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieModel, Long> {
        
}
