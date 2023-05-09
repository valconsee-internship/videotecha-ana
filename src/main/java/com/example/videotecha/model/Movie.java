package com.example.videotecha.model;

import com.example.videotecha.model.enums.Genre;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Movie {

    @Id
    @SequenceGenerator(name = "movieSequenceGenerator", sequenceName = "movieSequenceGenerator", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movieSequenceGenerator")
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String director;

    @Enumerated(value = EnumType.STRING)
    private List<Genre> genres = new ArrayList<>();

    @Column(nullable=false)
    private Integer length;

    @Column(nullable=false)
    private String description;

    public Movie() {}

    public Movie(String name, String director, List<Genre> genres, Integer length, String description) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && Objects.equals(director, movie.director) && Objects.equals(genres, movie.genres) && Objects.equals(length, movie.length) && Objects.equals(description, movie.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, director, genres, length, description);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", genres=" + genres +
                ", length=" + length +
                ", description='" + description + '\'' +
                '}';
    }
}
