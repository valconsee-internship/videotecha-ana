package com.example.videotecha.service;

import com.example.videotecha.model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User save(com.example.videotecha.dto.UserDto user);

}
