package com.example.videotecha.service.impl;

import com.example.videotecha.mapper.UserMapper;
import com.example.videotecha.model.User;
import com.example.videotecha.repository.UserRepository;
import com.example.videotecha.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository registeredUserRepository;

    public UserServiceImpl(UserRepository registeredUserRepository) {
        this.registeredUserRepository = registeredUserRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return registeredUserRepository.findAll();
    }

    @Override
    @Transactional
    public User save(com.example.videotecha.dto.UserDto user) {
        validateUser(user);
        return registeredUserRepository.save(UserMapper.userDtoToUser(user));
    }

    private void validateUser(com.example.videotecha.dto.UserDto user) {
        registeredUserRepository.findByEmail(user.getEmail())
                .ifPresent(u -> {
                    throw new RuntimeException("User with this username already exists");
                });

        registeredUserRepository.findByUsername(user.getUsername())
                .ifPresent(u -> {
                    throw new RuntimeException("User with this email already exists");
                });
    }
}
