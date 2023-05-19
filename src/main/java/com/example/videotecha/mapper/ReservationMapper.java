package com.example.videotecha.mapper;

import com.example.videotecha.dto.ReservationDto;
import com.example.videotecha.model.Reservation;

import java.util.List;

public final class ReservationMapper {

    private ReservationMapper() {}

    public static List<ReservationDto> reservationsToReservationDtos(List<Reservation> reservations) {
        return reservations.stream()
                .map(ReservationDto::new)
                .toList();
    }
}
