package com.example.videotecha.model;

import com.example.videotecha.model.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="\"user\"")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(nullable=false)
    private String firstName;

    @Column(nullable=false)
    private String lastName;

    @Column(unique=true, nullable=false)
    private String email;

    @Column(unique=true, nullable=false)
    private String username;

    @Column(nullable=false)
    private String password;

    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<>();

    public User() {}

    public User(String firstName, String lastName, String email, String username, String password, UserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public String toString() {
        return "RegisteredUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
