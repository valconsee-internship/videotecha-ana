package com.example.videotecha.controller;

import com.example.videotecha.dto.ProjectionCreationDto;
import com.example.videotecha.dto.ProjectionDto;
import com.example.videotecha.mapper.ProjectionMapper;
import com.example.videotecha.service.ProjectionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("projection")
public class ProjectionController {

    private final ProjectionService projectionService;

    public ProjectionController(ProjectionService projectionService) {
        this.projectionService = projectionService;
    }

    @PostMapping
    public ProjectionDto create(@Valid @RequestBody ProjectionCreationDto projectionCreationDto) {
        return new ProjectionDto(projectionService.create(projectionCreationDto));
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable("id") Long id) {
        return projectionService.delete(id);
    }

    @GetMapping("/available")
    public List<ProjectionDto> findAllAvailableProjections() {
        return ProjectionMapper.projectionsToProjectionDtos(projectionService.findAllAvailable());
    }

    @GetMapping
    public List<ProjectionDto> findAll() {
        return ProjectionMapper.projectionsToProjectionDtos(projectionService.findAll());
    }

    @GetMapping("/{id}")
    public ProjectionDto findById(@PathVariable("id") Long id) {
        return new ProjectionDto(projectionService.findById(id));
    }

}
