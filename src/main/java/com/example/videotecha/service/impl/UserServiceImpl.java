package com.example.videotecha.service.impl;

import com.example.videotecha.dto.UserCreationDto;
import com.example.videotecha.mapper.UserMapper;
import com.example.videotecha.model.User;
import com.example.videotecha.repository.UserRepository;
import com.example.videotecha.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User save(UserCreationDto user) {
        validateUser(user);
        return userRepository.save(UserMapper.userCreationDtoToUser(user));
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no user with this id."));
    }

    private void validateUser(UserCreationDto user) {
        userRepository.findByEmail(user.getEmail())
                .ifPresent(u -> {
                    throw new RuntimeException("User with this username already exists");
                });

        userRepository.findByUsername(user.getUsername())
                .ifPresent(u -> {
                    throw new RuntimeException("User with this email already exists");
                });
    }
}
