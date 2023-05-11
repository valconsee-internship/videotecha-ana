package com.example.videotecha.service.impl;

import com.example.videotecha.controller.TheaterController;
import com.example.videotecha.model.Theater;
import com.example.videotecha.repository.TheaterRepository;
import com.example.videotecha.service.TheaterService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;

    public TheaterServiceImpl(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }


    @Override
    public List<Theater> findAll() {
        return theaterRepository.findAll();
    }

    @Override
    public Theater findById(Long id) {
        return theaterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no theater with this id."));
    }
}
