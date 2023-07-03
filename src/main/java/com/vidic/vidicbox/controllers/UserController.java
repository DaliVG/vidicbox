package com.vidic.vidicbox.controllers;

import com.vidic.vidicbox.models.Users;
import com.vidic.vidicbox.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServices userService;

    @GetMapping
    public ResponseEntity<List<Users>> findAllUsers() {

        return ResponseEntity.ok(userService.getAllUsers());
    }
}
