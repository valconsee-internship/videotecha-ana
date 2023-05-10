package com.example.videotecha.controller;

import com.example.videotecha.dto.MovieDto;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/")
    public Movie create(@RequestBody MovieDto movieDto) {
        return movieService.save(MovieMapper.movieDtoToMovie(movieDto));
    }

    @GetMapping("/")
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable("id") Long id) {
        return movieService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Long delete(Long id) {
        return movieService.delete(id);
    }

}
