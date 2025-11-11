package com.example.backend.services;

import com.example.backend.exceptions.InvalidUserCredentials;
import com.example.backend.exceptions.UserExistsException;
import com.example.backend.exceptions.UserNotFoundException;
import com.example.backend.models.UserModel;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    public UserModel register(String username, String password) {
        if(userRepository.findByUsername(username).isPresent()) {
            throw new UserExistsException("User already exists");
        }
        UserModel user = new UserModel();
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }
    public String login(String username, String password) {
        UserModel existingUser = (UserModel) userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        if (!existingUser.getUsername().equals(username) || !existingUser.getPassword().equals(password)) {
            throw new InvalidUserCredentials("Invalid Username or Password");
        }

        return "Login Successful";
    }
    public String logout() {
        return "Logout Successful";
    }
}