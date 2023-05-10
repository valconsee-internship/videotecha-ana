package com.example.videotecha.service.impl;

import com.example.videotecha.model.Movie;
import com.example.videotecha.repository.MovieRepository;
import com.example.videotecha.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    @Transactional
    public Movie save(Movie movie) {
        assertMovieExists(movie);
        return movieRepository.save(movie);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movie> findAll() {
        return movieRepository.findByDeletedFalse();
    }

    @Override
    @Transactional(readOnly = true)
    public Movie findById(Long id) {
        return movieRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no movie with this id."));
    }

    @Override
    @Transactional
    public Long delete(Long id) {
        Movie movieForDeleting = movieRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no movie with this id."));

        movieRepository.deleteLogically(movieForDeleting.getId());
        return id;
    }

    @Override
    @Transactional
    public Movie update(Movie movie) {
        if(movieRepository.findByIdAndDeletedFalse(movie.getId()).isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no movie with this id.");
        }

        return movieRepository.save(movie);
    }

    private void assertMovieExists(Movie movie) {
        movieRepository.findByNameAndDeletedFalse(movie.getName())
                .ifPresent(m -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This movie already exists.");
                });
    }
}
