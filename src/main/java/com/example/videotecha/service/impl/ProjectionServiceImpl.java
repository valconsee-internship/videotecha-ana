package com.example.videotecha.service.impl;

import com.example.videotecha.repository.ProjectionRepository;
import com.example.videotecha.service.ProjectionService;
import org.springframework.stereotype.Service;

@Service
public class ProjectionServiceImpl implements ProjectionService {

    private final ProjectionRepository projectionRepository;

    public ProjectionServiceImpl(ProjectionRepository projectionRepository) {
        this.projectionRepository = projectionRepository;
    }

}
