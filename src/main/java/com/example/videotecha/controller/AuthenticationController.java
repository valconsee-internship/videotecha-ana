package com.example.videotecha.controller;

import com.example.videotecha.dto.UserDto;
import com.example.videotecha.model.User;
import com.example.videotecha.service.AuthenticationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public User register(@RequestBody UserDto user) {
        return authenticationService.register(user);
    }

}
