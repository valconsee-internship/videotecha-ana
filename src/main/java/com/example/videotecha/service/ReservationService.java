package com.example.videotecha.service;

import com.example.videotecha.dto.ReservationCreationDto;
import com.example.videotecha.model.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> create(ReservationCreationDto reservationCreationDto);

    Long cancel(Long id);

    List<Reservation> findAllActive();

    Reservation findById(Long id);

}
