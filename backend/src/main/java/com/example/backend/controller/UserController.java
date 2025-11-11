package com.example.backend.controller;

import com.example.backend.models.UserModel;
import com.example.backend.services.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public Iterable<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @PostMapping
    public UserModel addNewUser(@RequestBody UserModel user) {
        return userService.addNewUser(user);
    }
    @PutMapping("/{id}")
    public UserModel updateUser(@Valid @PathVariable Long id, UserModel updatedUser) {
        return userService.updateUser(id, updatedUser);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
