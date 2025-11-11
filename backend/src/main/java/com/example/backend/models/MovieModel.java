package com.example.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Entity
public class MovieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    private String movieName;//
    private String movieGenre;
    @DecimalMin("0.0")
    private Double movieRating;//
    private String moviePoster;//
    @Column(length = 1000)
    private String movieDescription;//
    @PositiveOrZero
    private int movieYear;
    @Positive
    private Integer movieDuration;//
}
