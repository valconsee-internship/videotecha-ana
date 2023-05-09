package com.example.videotecha.service;

import com.example.videotecha.dto.UserDto;
import com.example.videotecha.model.User;

public interface AuthenticationService {
    User register(UserDto user);
}
