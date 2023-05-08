package com.example.videotecha.service;

import com.example.videotecha.dto.UserDto;
import com.example.videotecha.model.RegisteredUser;

public interface AuthenticationService {
    RegisteredUser register(UserDto user);
}
