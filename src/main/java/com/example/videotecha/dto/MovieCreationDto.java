package com.example.videotecha.dto;

import com.example.videotecha.model.Movie;
import com.example.videotecha.model.enums.Genre;

import java.util.ArrayList;
import java.util.List;

public class MovieCreationDto {

    private String name;

    private String director;

    private List<Genre> genres = new ArrayList<>();

    private Integer length;

    private String description;

    public MovieCreationDto() {}

    public MovieCreationDto(String name, String director, List<Genre> genres, Integer length, String description) {
        this.name = name;
        this.director = director;
        this.genres = genres;
        this.length = length;
        this.description = description;
    }

    public MovieCreationDto(Movie movie) {
        this.name = movie.getName();
        this.director = movie.getDirector();
        this.genres = movie.getGenres();
        this.length = movie.getLength();
        this.description = movie.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public Integer getLength() {
        return length;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", genres=" + genres +
                ", length=" + length +
                ", description='" + description + '\'' +
                '}';
    }

}
