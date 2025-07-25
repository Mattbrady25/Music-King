package com.musicking.backend.service;

import com.musicking.backend.entity.UserAuthentication;
import com.musicking.backend.repository.UserAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthenticationService {

    private final UserAuthenticationRepository userRepository;

    @Autowired
    public UserAuthenticationService(UserAuthenticationRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserAuthentication> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserAuthentication registerUser(String username, String password) {
        // Later you’ll want to hash the password here before saving
        UserAuthentication user = new UserAuthentication(username, password);
        return userRepository.save(user);
    }

    public boolean userExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
    public UserAuthentication getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}

