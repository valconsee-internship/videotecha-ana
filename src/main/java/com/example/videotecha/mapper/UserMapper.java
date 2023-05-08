package com.example.videotecha.mapper;

import com.example.videotecha.dto.UserDto;
import com.example.videotecha.model.RegisteredUser;

public class UserMapper {

    public static RegisteredUser UserDtoToRegisteredUser(UserDto user) {
        return new RegisteredUser(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                user.getRole());
    }
}
