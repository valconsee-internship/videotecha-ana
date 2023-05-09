package com.example.videotecha.dto;

import com.example.videotecha.model.enums.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MovieDto {

    private String name;

    private String director;

    private List<Genre> genres = new ArrayList<>();

    private Integer length;

    private String description;

    public MovieDto() {}

    public MovieDto(String name, String director, List<Genre> genres, Integer length, String description) {
        this.name = name;
        this.director = director;
        this.genres = genres;
        this.length = length;
        this.description = description;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDto movieDto = (MovieDto) o;
        return Objects.equals(name, movieDto.name) && Objects.equals(director, movieDto.director) && Objects.equals(genres, movieDto.genres) && Objects.equals(length, movieDto.length) && Objects.equals(description, movieDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, director, genres, length, description);
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
