package com.example.videotecha.dto;

import com.example.videotecha.model.enums.Genre;

import java.util.ArrayList;
import java.util.List;

public class MovieForUpdateDto {

    private Long id;

    private String name;

    private String director;

    private List<Genre> genres = new ArrayList<>();

    private Integer length;

    private String description;

    public MovieForUpdateDto() {
    }

    public MovieForUpdateDto(Long id, String name, String director, List<Genre> genres, Integer length, String description) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.genres = genres;
        this.length = length;
        this.description = description;
    }

    public Long getId() {
        return id;
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
        return "MovieForUpdateDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", genres=" + genres +
                ", length=" + length +
                ", description='" + description + '\'' +
                '}';
    }

}
