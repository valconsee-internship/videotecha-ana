package com.example.videotecha.mapper;

import com.example.videotecha.dto.UserDto;
import com.example.videotecha.model.User;

import java.util.ArrayList;
import java.util.List;

public final class UserMapper {

    public static User userDtoToUser(UserDto user) {
        return new User(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                user.getRole());
    }

    public static List<UserDto> usersToUserDtos(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();

        for (User user : users) {
            userDtos.add(new UserDto(user));
        }

        return userDtos;
    }

}
