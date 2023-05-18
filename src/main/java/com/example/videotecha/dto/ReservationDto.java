package com.example.videotecha.dto;

import com.example.videotecha.model.Reservation;

public class ReservationDto {

    private Long id;

    private UserDto userDto;

    private ProjectionDto projectionDto;

    private int numberOfTickets;

    public ReservationDto() {
    }

    public ReservationDto(Long id, UserDto userDto, ProjectionDto projectionDto, int numberOfTickets) {
        this.id = id;
        this.userDto = userDto;
        this.projectionDto = projectionDto;
        this.numberOfTickets = numberOfTickets;
    }

    public ReservationDto(Reservation reservation, int numberOfTickets) {
        this.id = reservation.getId();
        this.projectionDto = new ProjectionDto(reservation.getProjection());
        this.userDto = new UserDto(reservation.getUser());
        this.numberOfTickets = numberOfTickets;
    }

    public Long getId() {
        return id;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public ProjectionDto getProjectionDto() {
        return projectionDto;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    @Override
    public String toString() {
        return "ReservationDto{" +
                "id=" + id +
                ", userDto=" + userDto +
                ", projectionDto=" + projectionDto +
                ", numberOfTickets=" + numberOfTickets +
                '}';
    }

}
