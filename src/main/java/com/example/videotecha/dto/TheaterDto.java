package com.example.videotecha.dto;

import com.example.videotecha.model.Theater;

public class TheaterDto {

    private Long id;

    private String name;

    private int numberOfSeats;

    public TheaterDto() {
    }
    public TheaterDto(Long id, String name, int numberOfSeats) {
        this.id = id;
        this.name = name;
        this.numberOfSeats = numberOfSeats;
    }

    public TheaterDto(Theater theater) {
        this.id = theater.getId();
        this.name = theater.getName();
        this.numberOfSeats = theater.getNumberOfSeats();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public String toString() {
        return "TheaterDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }

}
