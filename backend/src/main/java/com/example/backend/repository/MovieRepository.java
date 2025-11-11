package com.example.backend.repository;

import com.example.backend.models.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieModel, Long> {
}
