package com.example.videotecha.model.controller;

import com.example.videotecha.dto.UserDto;
import com.example.videotecha.model.RegisteredUser;
import com.example.videotecha.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public RegisteredUser register(@RequestBody UserDto user) {
        RegisteredUser registeredUser = authenticationService.register(user);
        return registeredUser;
    }

}
