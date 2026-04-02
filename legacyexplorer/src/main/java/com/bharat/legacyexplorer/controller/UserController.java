package com.bharat.legacyexplorer.controller;

import com.bharat.legacyexplorer.dto.RoleUpdateRequest;
import com.bharat.legacyexplorer.model.User;
import com.bharat.legacyexplorer.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{uid}/role")
    public User updateRole(@PathVariable("uid") Long uid, @RequestBody RoleUpdateRequest request) {
        return userService.updateRole(uid, request.role());
    }

    @GetMapping("/me")
    public User getMe() {
        return userService.getCurrentUser();
    }
}
