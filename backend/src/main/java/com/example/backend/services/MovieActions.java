package com.example.backend.services;

import com.example.backend.exceptions.MovieNotFoundException;
import com.example.backend.exceptions.UserNotFoundException;
import com.example.backend.models.MovieModel;
import com.example.backend.models.UserModel;
import com.example.backend.repository.MovieRepository;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieActions {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    @Transactional
    public UserModel addMovieToUserWatchlist(Long userId, Long movieId) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + userId));
        MovieModel movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with id " + movieId));

        if (user.getWatchList().contains(movie)) {
            throw new RuntimeException("Movie already in user's watchlist");
        }

        user.getWatchList().add(movie);

        return userRepository.save(user);
    }
    @Transactional
    public UserModel removeMovieFromUserWatchlist(Long userId, Long movieId) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + userId));
        MovieModel movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with id " + movieId));
        user.getWatchList().remove(movie);
        return userRepository.save(user);
    }
    public MovieModel getRandomMovie() {
        List<MovieModel> movies = movieRepository.findAll();
        if (movies.isEmpty()) {
            throw new UserNotFoundException("No movies available");
        }
        return movies.get((int) (Math.random() * movies.size()));
    }

    @Transactional
    public UserModel addMovieToUserWatchedList(Long userId, Long movieId) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + userId));
        MovieModel movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with id " + movieId));

        if (user.getWatchedList().contains(movie)) {
            throw new RuntimeException("Movie already in user's watchlist");
        }

        user.getWatchedList().add(movie);

        return userRepository.save(user);
    }
    @Transactional
    public UserModel removeMovieFromUserWatchedList(Long userId, Long movieId) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + userId));
        MovieModel movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with id " + movieId));
        user.getWatchedList().remove(movie);
        return userRepository.save(user);
    }
    @Transactional
    public UserModel addMovieToUserFavoriteMovie(Long userId, Long movieId) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found for ID: " + userId));
        MovieModel movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with id " + movieId));

        if (user.getFavoriteMovies().contains(movie)) {
            throw new RuntimeException("Movie already in user's watchlist");
        }

        user.getFavoriteMovies().add(movie);

        return userRepository.save(user);
    }
    @Transactional
    public UserModel removeMovieFromUserFavoriteMovie(Long userId, Long movieId) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + userId));
        MovieModel movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with id " + movieId));
        user.getFavoriteMovies().remove(movie);
        return userRepository.save(user);
    }

}
