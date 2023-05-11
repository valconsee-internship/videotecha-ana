package com.example.videotecha.service;

import com.example.videotecha.model.Theater;

import java.util.List;

public interface TheaterService {

    List<Theater> findAll();

    Theater findById(Long id);
}
