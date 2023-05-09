package com.example.videotecha.controller;

import com.example.videotecha.dto.MovieDto;
import com.example.videotecha.mapper.MovieMapper;
import com.example.videotecha.model.Movie;
import com.example.videotecha.service.MovieService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
