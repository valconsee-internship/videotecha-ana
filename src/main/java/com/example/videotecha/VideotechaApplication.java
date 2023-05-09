package com.example.videotecha;

import com.example.videotecha.model.RegisteredUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.UUID;

@SpringBootApplication
public class VideotechaApplication {

	public static HashMap<Long, RegisteredUser> users = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(VideotechaApplication.class, args);
	}

}
