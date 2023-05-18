package com.example.videotecha.mapper;

import com.example.videotecha.dto.ProjectionDto;
import com.example.videotecha.model.Projection;

import java.util.ArrayList;
import java.util.List;

public final class ProjectionMapper {

    public static List<ProjectionDto> projectionsToProjectionDtos(List<Projection> projections) {
        List<ProjectionDto> projectionDtos = new ArrayList<>();

        for(Projection projection : projections) {
            projectionDtos.add(new ProjectionDto(projection));
        }

        return projectionDtos;
    }

}
