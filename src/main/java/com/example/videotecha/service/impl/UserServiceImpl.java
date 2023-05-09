package com.example.videotecha.service.impl;

import com.example.videotecha.dto.UserDto;
import com.example.videotecha.mapper.UserMapper;
import com.example.videotecha.model.User;
import com.example.videotecha.repository.UserRepository;
import com.example.videotecha.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
    public User save(UserDto user) {
        validateUser(user);
        return registeredUserRepository.save(UserMapper.userDtoToRegisteredUser(user));
    }

    private void validateUser(UserDto user) {
        registeredUserRepository.findByEmail(user.getEmail())
                .ifPresent(u -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with this username already exists");
                });

        registeredUserRepository.findByUsername(user.getUsername())
                .ifPresent(u -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with this email already exists");
                });
    }
}
