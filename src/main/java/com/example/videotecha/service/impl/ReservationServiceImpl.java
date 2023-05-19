package com.example.videotecha.service.impl;

import com.example.videotecha.dto.ReservationCreationDto;
import com.example.videotecha.exception.MaximumNumberOfTicketsReachedException;
import com.example.videotecha.exception.ProjectionSoldOutException;
import com.example.videotecha.exception.TooLateCancellationException;
import com.example.videotecha.model.Projection;
import com.example.videotecha.model.Reservation;
import com.example.videotecha.model.User;
import com.example.videotecha.repository.ReservationRepository;
import com.example.videotecha.service.ProjectionService;
import com.example.videotecha.service.ReservationService;
import com.example.videotecha.service.UserService;
import jakarta.persistence.EntityNotFoundException;
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
            throw new ProjectionSoldOutException("Not enough tickets available for this projection.");
        }

        User user = userService.findById(reservationCreationDto.getUserId());

        List<Reservation> newReservations = new ArrayList<>();
        for(int i=0; i < reservationCreationDto.getNumberOfTickets(); i++) {
            Reservation reservation = new Reservation(user, projection);
            newReservations.add(reservation);
            reservationRepository.save(reservation);
        }

        projection.setNumberOfAvailableSeats(projection.getNumberOfAvailableSeats() - reservationCreationDto.getNumberOfTickets());

        return newReservations;
    }

    @Override
    @Transactional
    public Long cancel(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no reservation with this id."));

        canReservationBeCanceled(reservation.getProjection().getStartDateAndTime());

        reservation.setCanceled(true);
        reservation.getProjection().setNumberOfAvailableSeats(reservation.getProjection().getNumberOfAvailableSeats() + 1);
        reservationRepository.save(reservation);

        return id;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservation> findAllActive() {
        return reservationRepository.findAllByCanceledFalse();
    }

    @Override
    @Transactional(readOnly = true)
    public Reservation findById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no reservation with this id."));
    }

    private void canReservationBeCanceled(LocalDateTime projectionStartTime) {
        boolean isProjectionIn2HoursOrLess = LocalDateTime.now().isAfter(projectionStartTime.minusHours(2))
                && LocalDateTime.now().isBefore(projectionStartTime);

        if(isProjectionIn2HoursOrLess) {
            throw new TooLateCancellationException("Cannot cancel reservation less than two hours before projection.");
        }
    }

    private void isMaximumNumberOfReservationsForUserReached(ReservationCreationDto reservationCreationDto) {
        int reservedNumberOfTickets = reservationRepository.countByUserIdAndProjectionId(
                reservationCreationDto.getUserId(),
                reservationCreationDto.getProjectionId());

        int numberOfNewTickets = reservationCreationDto.getNumberOfTickets();

        if(reservedNumberOfTickets + numberOfNewTickets > 5) {
            throw new MaximumNumberOfTicketsReachedException("This user reached maximum number of reservations for this projection.");
        }
    }

}
