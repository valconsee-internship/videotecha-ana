package com.example.videotecha.service.impl;

import com.example.videotecha.model.Movie;
import com.example.videotecha.repository.MovieRepository;
import com.example.videotecha.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    @Transactional
    public Movie save(Movie movie) {
        validateMovie(movie);
        return movieRepository.save(movie);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Movie findById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no movie with this id."));
    }

    @Override
    @Transactional
    public Long delete(Long id) {
        Movie movieForDeleting = movieRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no movie with this id."));

        movieRepository.delete(movieForDeleting);
        return id;
    }

    @Override
    @Transactional
    public Movie update(Movie movie) {
        return movieRepository.save(movie);
    }

    private void validateMovie(Movie movie) {
        movieRepository.findByName(movie.getName())
                .ifPresent(m -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This movie already exists.");
                });
    }
}
