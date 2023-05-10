package com.example.videotecha.service.impl;

import com.example.videotecha.model.Movie;
import com.example.videotecha.repository.MovieRepository;
import com.example.videotecha.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie save(Movie movie) {
        validateMovie(movie);
        return movieRepository.save(movie);
    }

    private void validateMovie(Movie movie) {
        movieRepository.findByName(movie.getName())
                .ifPresent(m -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This movie already exists.");
                });
    }
}
