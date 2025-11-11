package com.example.backend.controller;

import com.example.backend.models.UserModel;
import com.example.backend.services.AuthService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @RequestMapping("/login")
    public String login(String username, String password) {
        return authService.login(username, password);
    }
    @RequestMapping("/register")
    public UserModel register(String username, String password) {
        return authService.register(username, password);
    }
    @RequestMapping("/logout")
    public String logout() {
        return authService.logout();
    }
}
