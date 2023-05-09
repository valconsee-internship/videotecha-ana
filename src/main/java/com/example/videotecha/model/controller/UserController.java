package com.example.videotecha.model.controller;

import com.example.videotecha.model.RegisteredUser;
import com.example.videotecha.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<RegisteredUser> getAllUsers() {
        return userService.findAllUsers();
    }
}
