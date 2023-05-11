package com.example.videotecha.dto;

import java.util.Date;

public class ProjectionDto {

    private Long id;

    private MovieDto movieDto;

    private TheaterDto theaterDto;

    private Date startDateAndTime;

    private int ticketPrice;

    public ProjectionDto() {
    }

    public ProjectionDto(Long id, MovieDto movieDto, TheaterDto theaterDto, Date startDateAndTime, int ticketPrice) {
        this.id = id;
        this.movieDto = movieDto;
        this.theaterDto = theaterDto;
        this.startDateAndTime = startDateAndTime;
        this.ticketPrice = ticketPrice;
    }

    public Long getId() {
        return id;
    }

    public MovieDto getMovieDto() {
        return movieDto;
    }

    public TheaterDto getTheaterDto() {
        return theaterDto;
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
                ", movieDto=" + movieDto +
                ", theaterDto=" + theaterDto +
                ", startDateAndTime=" + startDateAndTime +
                ", ticketPrice=" + ticketPrice +
                '}';
    }

}
