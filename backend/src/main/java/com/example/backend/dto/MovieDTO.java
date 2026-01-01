package com.example.backend.dto;

public record MovieDTO(Long movieId,
                       String movieName,
                       String movieGenre,
                       Double movieRating,
                       String moviePoster,
                       String movieDescription,
                       int movieYear,
                       int movieDuration) {
}
