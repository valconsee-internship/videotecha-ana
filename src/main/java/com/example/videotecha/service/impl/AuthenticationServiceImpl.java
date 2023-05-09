package com.example.videotecha.service.impl;

import com.example.videotecha.dto.UserDto;
import com.example.videotecha.mapper.UserMapper;
import com.example.videotecha.model.RegisteredUser;
import com.example.videotecha.repository.RegisteredUserRepository;
import com.example.videotecha.service.AuthenticationService;
import com.example.videotecha.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;

    public AuthenticationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Transactional
    public RegisteredUser register(UserDto user) {
        return userService.save(user);
    }


}
