package com.example.videotecha.controller;

import com.example.videotecha.dto.TheaterDto;
import com.example.videotecha.mapper.TheaterMapper;
import com.example.videotecha.service.TheaterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("theater")
public class TheaterController {

    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping
    public List<TheaterDto> findAll() {
        return TheaterMapper.theatersToTheaterDtos(theaterService.findAll());
    }

    @GetMapping("/{id}")
    public TheaterDto findById(@PathVariable("id") Long id) {
        return new TheaterDto(theaterService.findById(id));
    }

}
