package com.example.pathfinder.repository;

import com.example.pathfinder.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
