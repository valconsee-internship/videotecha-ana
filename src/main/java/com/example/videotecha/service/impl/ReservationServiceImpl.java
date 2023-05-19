package com.example.videotecha.service.impl;

import com.example.videotecha.dto.ReservationCreationDto;
import com.example.videotecha.model.Projection;
import com.example.videotecha.model.Reservation;
import com.example.videotecha.model.User;
import com.example.videotecha.repository.ReservationRepository;
import com.example.videotecha.service.ProjectionService;
import com.example.videotecha.service.ReservationService;
import com.example.videotecha.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    private final ProjectionService projectionService;

    private final UserService userService;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ProjectionService projectionService, UserService userService) {
        this.reservationRepository = reservationRepository;
        this.projectionService = projectionService;
        this.userService = userService;
    }

    @Override
    @Transactional
    public List<Reservation> create(ReservationCreationDto reservationCreationDto) {
        isMaximumNumberOfReservationsForUserReached(reservationCreationDto);

        Projection projection = projectionService.findById(reservationCreationDto.getProjectionId());

        if(projection.getNumberOfAvailableSeats() - reservationCreationDto.getNumberOfTickets() < 0) {
            throw new RuntimeException("Not enough tickets available for this projection.");
        }

        User user = userService.findById(reservationCreationDto.getUserId());

        List<Reservation> newReservations = new ArrayList<>();
        for(int i=0; i < reservationCreationDto.getNumberOfTickets(); i++) {
            Reservation reservation = new Reservation(user, projection);
            projection.setNumberOfAvailableSeats(projection.getNumberOfAvailableSeats() - 1);

            newReservations.add(reservation);
            reservationRepository.save(reservation);
        }

        return newReservations;
    }

    private void isMaximumNumberOfReservationsForUserReached(ReservationCreationDto reservationCreationDto) {
        if(reservationRepository.findNumberOfReservationsByUserIdAndProjectionId(
                reservationCreationDto.getProjectionId(),
                reservationCreationDto.getUserId()) + reservationCreationDto.getNumberOfTickets() > 5) {
            throw new RuntimeException("This user reached maximum number of reservations for this projection.");
        }
    }
}
