package com.example.videotecha.service.impl;

import com.example.videotecha.model.Movie;
import com.example.videotecha.repository.MovieRepository;
import com.example.videotecha.service.MovieService;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }
}
