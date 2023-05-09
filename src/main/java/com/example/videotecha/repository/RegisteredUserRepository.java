package com.example.videotecha.repository;

import com.example.videotecha.model.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Long> {
    Optional<RegisteredUser> findByEmail(String email);
    Optional<RegisteredUser> findByUsername(String username);
}
