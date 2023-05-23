package com.example.videotecha.service.impl;

import com.example.videotecha.dto.UserCreationDto;
import com.example.videotecha.model.User;
import com.example.videotecha.service.AuthenticationService;
import com.example.videotecha.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;

    public AuthenticationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Transactional
    public User register(UserCreationDto user) {
        return userService.save(user);
    }


}
