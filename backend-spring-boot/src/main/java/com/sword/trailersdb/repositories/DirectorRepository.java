package com.sword.trailersdb.repositories;

import com.sword.trailersdb.data.models.DirectorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<DirectorModel, Long> {

}
