package com.example.videotecha.service.hashMapImpl;


import com.example.videotecha.VideotechaApplication;
import com.example.videotecha.model.RegisteredUser;
import com.example.videotecha.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<RegisteredUser> getAllUsers() {
        return new ArrayList<RegisteredUser>(VideotechaApplication.users.values());
    }
}
