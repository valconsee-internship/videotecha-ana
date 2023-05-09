package com.example.videotecha.service.impl;

import com.example.videotecha.dto.UserDto;
import com.example.videotecha.mapper.UserMapper;
import com.example.videotecha.model.RegisteredUser;
import com.example.videotecha.repository.RegisteredUserRepository;
import com.example.videotecha.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    RegisteredUserRepository registeredUserRepository;

    public AuthenticationServiceImpl(RegisteredUserRepository registeredUserRepository) {
        this.registeredUserRepository = registeredUserRepository;
    }

    @Override
    public RegisteredUser register(UserDto user) {
        validateUser(user);
        return registeredUserRepository.save(UserMapper.UserDtoToRegisteredUser(user));
    }

    private void validateUser(UserDto user) {
        if(registeredUserRepository.findByEmail(user.getEmail()) != null) {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with this username already exists");
        }

        if(registeredUserRepository.findByUsername(user.getUsername()) != null) {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with this email already exists");
        }
    }
}
