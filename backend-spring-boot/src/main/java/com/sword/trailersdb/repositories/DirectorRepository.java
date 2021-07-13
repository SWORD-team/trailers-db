package com.sword.trailersdb.repositories;

import com.sword.trailersdb.models.DirectorModel;
import org.springframework.data.jpa.repository.JpaRepository;

interface DirectorRepository extends JpaRepository<DirectorModel, Long> {
}