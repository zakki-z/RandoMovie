package com.example.backend.services;

import com.example.backend.exceptions.UserNotFoundException;
import com.example.backend.models.UserModel;
import com.example.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }
    public UserModel getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found for ID: " + id));
    }
    public UserModel addNewUser(UserModel user) {
        return userRepository.save(user);
    }
    public UserModel updateUser(Long id, UserModel updatedUser) {
        UserModel existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found for ID: " + id));
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPassword(updatedUser.getPassword());
        return userRepository.save(existingUser);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
