package com.vidic.vidicbox.controllers;

import com.vidic.vidicbox.models.Users;
import com.vidic.vidicbox.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {
    private final UserServices userService;

    @GetMapping("/users")
    public ResponseEntity<List<Users>> findAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/users/signup")
    private ResponseEntity createUsers(@RequestBody Users user) {
        try {
            userService.saveOrUpdate(user);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("New user created with username: " + user.getUsername(), HttpStatus.CREATED);
    }
}