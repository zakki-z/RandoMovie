package com.example.backend.controller;

import com.example.backend.models.MovieModel;
import com.example.backend.models.UserModel;
import com.example.backend.services.MovieActions;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movieActions")
public class MovieActionsController {
    private final MovieActions movieActions;
    public MovieActionsController(MovieActions movieActions) {
        this.movieActions = movieActions;
    }
    @RequestMapping("/random")
    public MovieModel getRandomMovie(){
        return movieActions.getRandomMovie();
    }
    @PostMapping("/watchlist")
    public UserModel addMovieToUserWatchlist(Long userId, Long movieId) {
        return movieActions.addMovieToUserWatchlist(userId, movieId);
    }
    @DeleteMapping("/watchlist")
    public UserModel removeMovieFromUserWatchlist(Long userId, Long movieId) {
        return movieActions.removeMovieFromUserWatchlist(userId, movieId);
    }
    @PostMapping("/watchedList")
    public UserModel addMovieToUserWatchedList(Long userId, Long movieId) {
        return movieActions.addMovieToUserWatchedList(userId, movieId);
    }
    @DeleteMapping("/watchedList")
    public UserModel removeMovieFromUserWatchedList(Long userId, Long movieId) {
        return movieActions.removeMovieFromUserWatchedList(userId, movieId);
    }
    @PostMapping("/favoriteMovie")
    public UserModel addMovieToUserFavoriteMovie(Long userId, Long movieId) {
        return movieActions.addMovieToUserFavoriteMovie(userId, movieId);
    }
    @DeleteMapping("/favoriteMovie")
    public UserModel removeMovieFromUserFavoriteMovie(Long userId, Long movieId) {
        return movieActions.removeMovieFromUserFavoriteMovie(userId, movieId);
    }
}
