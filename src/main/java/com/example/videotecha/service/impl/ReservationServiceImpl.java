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

import java.time.LocalDateTime;
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

    @Override
    @Transactional
    public Long cancel(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no reservation with this id."));

        canReservationBeCanceled(reservation.getProjection().getStartDateAndTime());

        reservation.setCanceled(true);
        reservation.getProjection().setNumberOfAvailableSeats(reservation.getProjection().getNumberOfAvailableSeats() + 1);
        reservationRepository.save(reservation);

        return id;
    }

    @Override
    public List<Reservation> findAllActive() {
        return reservationRepository.findAllByCanceledFalse();
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no reservation with this id."));
    }

    private void canReservationBeCanceled(LocalDateTime projectionStartTime) {
        if(LocalDateTime.now().isAfter(projectionStartTime.minusHours(2)) && LocalDateTime.now().isBefore(projectionStartTime)) {
            throw new RuntimeException("Cannot cancel reservation less than two hours before projection.");
        }
    }

    private void isMaximumNumberOfReservationsForUserReached(ReservationCreationDto reservationCreationDto) {
        if(reservationRepository.findNumberOfReservationsByUserIdAndProjectionId(
                reservationCreationDto.getProjectionId(),
                reservationCreationDto.getUserId()) + reservationCreationDto.getNumberOfTickets() > 5) {
            throw new RuntimeException("This user reached maximum number of reservations for this projection.");
        }
    }
    
}
