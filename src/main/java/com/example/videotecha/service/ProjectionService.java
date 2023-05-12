package com.example.videotecha.service;

import com.example.videotecha.dto.ProjectionCreationDto;
import com.example.videotecha.dto.ProjectionDto;

public interface ProjectionService {
    ProjectionDto create(ProjectionCreationDto projectionCreationDto);
}
