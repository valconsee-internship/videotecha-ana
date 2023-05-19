package com.example.videotecha.dto;

public class ReservationCreationDto {

    private Long projectionId;

    private Long userId;

    private int numberOfTickets;

    public ReservationCreationDto() {
    }

    public Long getProjectionId() {
        return projectionId;
    }

    public Long getUserId() {
        return userId;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    @Override
    public String toString() {
        return "ReservationCreationDto{" +
                "projectionId=" + projectionId +
                ", userId=" + userId +
                ", numberOfTickets=" + numberOfTickets +
                '}';
    }

}
