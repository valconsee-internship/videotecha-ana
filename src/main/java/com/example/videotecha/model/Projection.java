package com.example.videotecha.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

import java.util.Date;

@Entity
public class Projection {

    @Id
    @SequenceGenerator(name = "movieSequenceGenerator", sequenceName = "movieSequenceGenerator", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movieSequenceGenerator")
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="movie_id", nullable=false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="theater_id", nullable=false)
    private Theater theater;

    @Column(nullable=false)
    private Date startDateAndTime;

    @Column(nullable=false)
    private int ticketPrice;

    @Column(nullable=false)
    private int numberOfAvailableSeats;

    private Boolean deleted = false;

    public Projection() {}

    public Projection(Movie movie, Theater theater, Date startDateAndTime, int ticketPrice) {
        this.movie = movie;
        this.theater = theater;
        this.startDateAndTime = startDateAndTime;
        this.ticketPrice = ticketPrice;
        this.numberOfAvailableSeats = theater.getNumberOfSeats();
    }

    public Projection(Movie movie, Theater theater, Date startDateAndTime, int ticketPrice, Boolean deleted) {
        this.movie = movie;
        this.theater = theater;
        this.startDateAndTime = startDateAndTime;
        this.ticketPrice = ticketPrice;
        this.numberOfAvailableSeats = theater.getNumberOfSeats();
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public Date getStartDateAndTime() {
        return startDateAndTime;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public void setStartDateAndTime(Date startDateAndTime) {
        this.startDateAndTime = startDateAndTime;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    @Override
    public String toString() {
        return "Projection{" +
                "id=" + id +
                ", movie=" + movie +
                ", theater=" + theater +
                ", startDateAndTime=" + startDateAndTime +
                ", ticketPrice=" + ticketPrice +
                ", numberOfAvailableSeats=" + numberOfAvailableSeats +
                ", deleted=" + deleted +
                '}';
    }

}
