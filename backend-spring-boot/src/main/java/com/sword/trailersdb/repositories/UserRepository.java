package com.sword.trailersdb.repositories;

import com.sword.trailersdb.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
        
}
