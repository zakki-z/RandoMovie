package com.example.backend.dto;

import java.util.List;

public record UserDTO(Long id,
                      String username,
                      List<MovieDTO> favoriteMovies,
                      List<MovieDTO> watchList,
                      List<MovieDTO> watchedList
) {
}
