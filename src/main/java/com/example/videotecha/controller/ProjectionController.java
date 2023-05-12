package com.example.videotecha.controller;

import com.example.videotecha.dto.ProjectionCreationDto;
import com.example.videotecha.dto.ProjectionDto;
import com.example.videotecha.service.ProjectionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("projection")
public class ProjectionController {

    private final ProjectionService projectionService;

    public ProjectionController(ProjectionService projectionService) {
        this.projectionService = projectionService;
    }

    @PostMapping
    public ProjectionDto create(@RequestBody ProjectionCreationDto projectionCreationDto) {
        return projectionService.create(projectionCreationDto);
    }

}
