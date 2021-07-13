package com.sword.trailersdb.repositories;

import com.sword.trailersdb.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;

interface MovieRepository extends JpaRepository<Director, Long> {



}
