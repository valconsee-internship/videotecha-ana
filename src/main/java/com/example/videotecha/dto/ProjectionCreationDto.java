package com.example.videotecha.dto;

import java.util.Date;

public class ProjectionCreationDto {

    private Long id;

    private Long movieId;

    private Long theaterId;

    private Date startDateAndTime;

    private int ticketPrice;

    public ProjectionCreationDto() {
    }

    public ProjectionCreationDto(Long id, Long movieId, Long theaterId, Date startDateAndTime, int ticketPrice) {
        this.id = id;
        this.movieId = movieId;
        this.theaterId = theaterId;
        this.startDateAndTime = startDateAndTime;
        this.ticketPrice = ticketPrice;
    }

    public Long getId() {
        return id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public Long getTheaterId() {
        return theaterId;
    }

    public Date getStartDateAndTime() {
        return startDateAndTime;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public String toString() {
        return "ProjectionDto{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", theaterId=" + theaterId +
                ", startDateAndTime=" + startDateAndTime +
                ", ticketPrice=" + ticketPrice +
                '}';
    }

}
