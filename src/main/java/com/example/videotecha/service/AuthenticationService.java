package com.example.videotecha.service;

import com.example.videotecha.dto.UserCreationDto;
import com.example.videotecha.model.User;

public interface AuthenticationService {

    User register(UserCreationDto user);
    
}
