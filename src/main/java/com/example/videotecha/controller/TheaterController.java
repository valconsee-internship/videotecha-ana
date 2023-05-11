package com.example.videotecha.controller;

import com.example.videotecha.model.Theater;
import com.example.videotecha.service.TheaterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("theater")
public class TheaterController {

    TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping
    public List<Theater> findAll() {
        return theaterService.findAll();
    }

    @GetMapping("/{id}")
    public Theater findById(@PathVariable("id") Long id) {
        return theaterService.findById(id);
    }

}
