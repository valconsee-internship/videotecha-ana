package com.example.videotecha.repository;

import com.example.videotecha.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findByName(String name);
}
