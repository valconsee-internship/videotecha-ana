package com.example.videotecha.controller;

import com.example.videotecha.dto.UserDto;
import com.example.videotecha.mapper.UserMapper;
import com.example.videotecha.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAll() {
        return UserMapper.usersToUserDtos(userService.findAllUsers());
    }

}
