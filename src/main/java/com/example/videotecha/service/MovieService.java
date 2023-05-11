package com.example.videotecha.service;

import com.example.videotecha.model.Movie;

import java.util.List;

public interface MovieService {

    Movie save(Movie movieDtoToMovie);

    List<Movie> findAll();

    Movie findById(Long id);

    Long delete(Long id);

    Movie update(Movie movie);
}
