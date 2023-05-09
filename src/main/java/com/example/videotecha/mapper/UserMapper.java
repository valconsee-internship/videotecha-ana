package com.example.videotecha.mapper;

import com.example.videotecha.dto.UserDto;
import com.example.videotecha.model.User;

public class UserMapper {

    public static User userDtoToRegisteredUser(UserDto user) {
        return new User(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                user.getRole());
    }
}
