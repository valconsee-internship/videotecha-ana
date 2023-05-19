package com.example.videotecha.controller;

import com.example.videotecha.dto.ReservationCreationDto;
import com.example.videotecha.dto.ReservationDto;
import com.example.videotecha.mapper.ReservationMapper;
import com.example.videotecha.model.Reservation;
import com.example.videotecha.service.ReservationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public List<ReservationDto> create(@RequestBody ReservationCreationDto reservationCreationDto) {
        return ReservationMapper.reservationsToReservationDtos(reservationService.create(reservationCreationDto));
    }

}
