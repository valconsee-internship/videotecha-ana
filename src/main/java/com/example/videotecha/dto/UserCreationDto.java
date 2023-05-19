package com.example.videotecha.dto;

import com.example.videotecha.model.User;
import com.example.videotecha.model.enums.UserRole;

public class UserCreationDto {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private UserRole role;

    public UserCreationDto() {}

    public UserCreationDto(String firstName, String lastName, String email, String username, String password, UserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserCreationDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.role = user.getRole();
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

}
