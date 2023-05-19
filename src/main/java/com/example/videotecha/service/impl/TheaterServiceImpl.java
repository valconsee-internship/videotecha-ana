package com.example.videotecha.service.impl;

import com.example.videotecha.model.Theater;
import com.example.videotecha.repository.TheaterRepository;
import com.example.videotecha.service.TheaterService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new EntityNotFoundException("There is no theater with this id."));
    }
}
