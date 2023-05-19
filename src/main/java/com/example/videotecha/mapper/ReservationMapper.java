package com.example.videotecha.mapper;

import com.example.videotecha.dto.ReservationDto;
import com.example.videotecha.model.Reservation;

import java.util.ArrayList;
import java.util.List;

public final class ReservationMapper {

    public static List<ReservationDto> reservationsToReservationDtos(List<Reservation> reservations) {
        List<ReservationDto> reservationDtos = new ArrayList<>();
        reservations.forEach(r -> reservationDtos.add(new ReservationDto(r)));

        return reservationDtos;
    }
}
