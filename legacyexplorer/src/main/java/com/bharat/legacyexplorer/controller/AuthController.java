package com.bharat.legacyexplorer.controller;

import com.bharat.legacyexplorer.dto.LoginRequest;
import com.bharat.legacyexplorer.dto.LoginResponse;
import com.bharat.legacyexplorer.dto.RegisterRequest;
import com.bharat.legacyexplorer.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "https://blx-fend-1.vercel.app")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public LoginResponse register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
}
