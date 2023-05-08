package com.example.videotecha.service.hashMapImpl;

import com.example.videotecha.VideotechaApplication;
import com.example.videotecha.dto.UserDto;
import com.example.videotecha.mapper.UserMapper;
import com.example.videotecha.model.RegisteredUser;
import com.example.videotecha.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.UUID;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public RegisteredUser register(UserDto user) {
        validateUser(user);

        RegisteredUser registeredUser = UserMapper.UserDtoToRegisteredUser(user);
        registeredUser.setId(UUID.randomUUID().toString());

        VideotechaApplication.users.put(registeredUser.getId(), registeredUser);

        return registeredUser;
    }

    private void validateUser(UserDto user) {
        if(usernameExists(user.getUsername())) throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with this username already exists");
        if(emailExists(user.getEmail())) throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with this email already exists");
    }

    private boolean emailExists(String email) {
        for (Map.Entry<String, RegisteredUser> entry : VideotechaApplication.users.entrySet()) {
            RegisteredUser registeredUser = entry.getValue();
            if (registeredUser.getEmail().equals(email)) return true;
        }
        return false;
    }

    private boolean usernameExists(String username) {
        for (Map.Entry<String, RegisteredUser> entry : VideotechaApplication.users.entrySet()) {
            RegisteredUser registeredUser = entry.getValue();
            if (registeredUser.getUsername().equals(username)) return true;
        }
        return false;
    }
}
