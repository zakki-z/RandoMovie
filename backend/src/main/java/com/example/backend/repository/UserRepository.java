package com.example.backend.repository;

import com.example.backend.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<Object> findByUsername(String username);
}
