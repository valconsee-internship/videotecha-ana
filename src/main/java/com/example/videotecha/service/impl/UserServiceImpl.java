package com.example.videotecha.service.impl;

import com.example.videotecha.model.RegisteredUser;
import com.example.videotecha.repository.RegisteredUserRepository;
import com.example.videotecha.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    RegisteredUserRepository registeredUserRepository;

    public UserServiceImpl(RegisteredUserRepository registeredUserRepository) {
        this.registeredUserRepository = registeredUserRepository;
    }

    @Override
    public List<RegisteredUser> getAllUsers() {
        return registeredUserRepository.findAll();
    }
}
