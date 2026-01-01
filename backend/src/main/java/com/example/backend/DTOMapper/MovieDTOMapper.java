package com.example.backend.DTOMapper;

import com.example.backend.dto.MovieDTO;
import com.example.backend.models.MovieModel;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class MovieDTOMapper implements Function<MovieModel, MovieDTO> {
    @Override
    public MovieDTO apply(MovieModel movieModel) {
        return new MovieDTO(movieModel.getMovieId(),
                movieModel.getMovieName(),
                movieModel.getMovieGenre(),
                movieModel.getMovieRating(),
                movieModel.getMoviePoster(),
                movieModel.getMovieDescription(),
                movieModel.getMovieYear(),
                movieModel.getMovieDuration());
    }
}
