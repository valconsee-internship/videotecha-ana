package com.example.videotecha.service;

import com.example.videotecha.dto.UserCreationDto;
import com.example.videotecha.model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User save(UserCreationDto user);

    User findById(Long id);

}
