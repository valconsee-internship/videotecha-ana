package com.example.videotecha.service;

import com.example.videotecha.dto.ProjectionCreationDto;
import com.example.videotecha.model.Projection;

import java.util.List;

public interface ProjectionService {

    Projection create(ProjectionCreationDto projectionCreationDto);

    Long delete(Long id);

    List<Projection> findAllAvailableProjections();

    List<Projection> findAll();

    Projection findById(Long id);
}
