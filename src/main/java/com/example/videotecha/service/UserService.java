package com.example.videotecha.service;

import com.example.videotecha.dto.UserDto;
import com.example.videotecha.model.RegisteredUser;

import java.util.List;

public interface UserService {

    List<RegisteredUser> findAllUsers();

    RegisteredUser save(UserDto user);
}
