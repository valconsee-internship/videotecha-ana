package com.example.videotecha.controller;

import com.example.videotecha.dto.MovieCreationDto;
import com.example.videotecha.dto.MovieDto;
import com.example.videotecha.dto.MovieForUpdateDto;
import com.example.videotecha.mapper.MovieMapper;
import com.example.videotecha.model.Movie;
import com.example.videotecha.service.MovieService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public MovieDto create(@RequestBody MovieCreationDto movieDto) {
        Movie newMovie = movieService.save(MovieMapper.movieDtoToMovie(movieDto));
        return new MovieDto(newMovie);
    }

    @GetMapping
    public List<MovieDto> findAll() {
        return MovieMapper.moviesToMovieDtos(movieService.findAll());
    }

    @GetMapping("/{id}")
    public MovieDto findById(@PathVariable("id") Long id) {
        return new MovieDto(movieService.findById(id));
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable("id") Long id) {
        return movieService.delete(id);
    }

    @PutMapping
    public MovieDto update(@RequestBody MovieForUpdateDto movie) {
        return new MovieDto(movieService.update(movie));
    }

}
