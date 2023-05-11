package com.example.videotecha.service;

import com.example.videotecha.model.User;

public interface AuthenticationService {
    User register(com.example.videotecha.dto.UserDto user);

}
