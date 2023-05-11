package com.example.videotecha.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Theater {

    @Id
    @SequenceGenerator(name = "theaterSequenceGenerator", sequenceName = "theaterSequenceGenerator", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "theaterSequenceGenerator")
    @Column(name="id")
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private int numberOfSeats;

    public Theater() {}

    public Theater(String name, int numberOfSeats) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
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
        return "Theater{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }
}
