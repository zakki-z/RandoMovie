package com.example.backend.services;

import com.example.backend.models.MovieModel;
import com.example.backend.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public MovieModel getMovieById(Long movieId){
        return movieRepository.findById(movieId).orElse(null);
    }
    public Iterable<MovieModel> getAllMovies(){
        return movieRepository.findAll();
    }
    public MovieModel addNewMovie(MovieModel movieModel){
        return movieRepository.save(movieModel);
    }
    public MovieModel updateMovie(long id, MovieModel UpdatedMovie){
        MovieModel existingMovie = movieRepository.findById(id).orElse(null);
        assert existingMovie != null;
        existingMovie.setMovieDuration(UpdatedMovie.getMovieDuration());
        existingMovie.setMovieName(UpdatedMovie.getMovieName());
        existingMovie.setMovieDescription(UpdatedMovie.getMovieDescription());
        existingMovie.setMovieRating(UpdatedMovie.getMovieRating());
        existingMovie.setMoviePoster(UpdatedMovie.getMoviePoster());
        existingMovie.setMovieGenre(UpdatedMovie.getMovieGenre());
        existingMovie.setMovieYear(UpdatedMovie.getMovieYear());
        return movieRepository.save(existingMovie);
    }
    public void deleteMovieById(Long movieId){
        movieRepository.deleteById(movieId);
    }
}
