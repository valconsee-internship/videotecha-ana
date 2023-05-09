package com.example.videotecha.repository;

import com.example.videotecha.model.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Long> {
    RegisteredUser findByEmail(String email);
    RegisteredUser findByUsername(String username);
}
