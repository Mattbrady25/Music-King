package com.musicking.backend.controller;

import com.musicking.backend.entity.UserAuthentication;
import com.musicking.backend.service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserAuthenticationController {

    private final UserAuthenticationService userService;

    @Autowired
    public UserAuthenticationController(UserAuthenticationService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public UserAuthentication getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }
}

