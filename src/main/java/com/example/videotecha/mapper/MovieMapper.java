package com.example.videotecha.mapper;

import com.example.videotecha.dto.MovieDto;
import com.example.videotecha.model.Movie;

public class MovieMapper {

    public static Movie movieDtoToMovie(MovieDto movieDto) {
        return new Movie(
                movieDto.getName(),
                movieDto.getDirector(),
                movieDto.getGenres(),
                movieDto.getLength(),
                movieDto.getDescription());
    }
}
