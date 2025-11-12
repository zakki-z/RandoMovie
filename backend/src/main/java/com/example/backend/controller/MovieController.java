package com.example.backend.controller;

import com.example.backend.models.MovieModel;
import com.example.backend.services.MovieService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping("/{id}")
    public MovieModel getMovieById(@PathVariable Long id){
        return movieService.getMovieById(id);
    }
    @GetMapping
    public Iterable<MovieModel> getAllMovies(){
        return movieService.getAllMovies();
    }
    @PostMapping
    public MovieModel addNewMovie(@RequestBody MovieModel movieModel){
        return movieService.addNewMovie(movieModel);
    }
    @PutMapping("/{id}")
    public MovieModel updateMovie(@PathVariable  Long id, @Valid @RequestBody MovieModel movieModel){
        return movieService.updateMovie(id,movieModel);
    }
    @DeleteMapping("/{id}")
    public void deleteMovieById(@PathVariable Long id){
        movieService.deleteMovieById(id);
    }
}
