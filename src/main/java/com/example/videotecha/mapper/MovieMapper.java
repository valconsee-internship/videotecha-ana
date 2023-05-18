package com.example.videotecha.mapper;

import com.example.videotecha.dto.MovieDto;
import com.example.videotecha.model.Movie;

import java.util.ArrayList;
import java.util.List;

public final class MovieMapper {

    private MovieMapper() {}

    public static Movie movieDtoToMovie(MovieDto movieDto) {
        return new Movie(
                movieDto.getName(),
                movieDto.getDirector(),
                movieDto.getGenres(),
                movieDto.getLength(),
                movieDto.getDescription());
    }

    public static List<MovieDto> moviesToMovieDtos(List<Movie> movies) {
        List<MovieDto> movieDtos = new ArrayList<>();

        for (Movie movie : movies) {
            movieDtos.add(new MovieDto(movie));
        }

        return movieDtos;
    }

}
