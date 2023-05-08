package com.example.videotecha.model.controller;

import com.example.videotecha.dto.UserDto;
import com.example.videotecha.model.RegisteredUser;
import com.example.videotecha.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<RegisteredUser> register(@RequestBody UserDto user) {
        RegisteredUser registeredUser = authenticationService.register(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.OK);
    }

}
