package com.example.videotecha.controller;

import com.example.videotecha.dto.UserCreationDto;
import com.example.videotecha.dto.UserDto;
import com.example.videotecha.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public UserDto register(@Valid @RequestBody UserCreationDto user) {
        return new UserDto(authenticationService.register(user));
    }

}
