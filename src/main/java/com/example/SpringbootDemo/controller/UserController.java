package com.example.SpringbootDemo.controller;

import com.example.SpringbootDemo.entity.User;
import com.example.SpringbootDemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/public")
    public String getPublic() {
        return "This is a public endpoint.";
    }

    @GetMapping("/user")
    public String getUser() {
        return "This is a user endpoint.";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "This is an admin endpoint.";
    }
    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            userService.createUser(user);
            return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Failed to create user", HttpStatus.BAD_REQUEST);
        }
    }

}
