package com.bharat.legacyexplorer.service;

import com.bharat.legacyexplorer.dto.LoginRequest;
import com.bharat.legacyexplorer.dto.LoginResponse;
import com.bharat.legacyexplorer.dto.RegisterRequest;
import com.bharat.legacyexplorer.model.User;
import com.bharat.legacyexplorer.repository.UserRepository;
import com.bharat.legacyexplorer.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public LoginResponse register(RegisterRequest request) {
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already registered");
        }
        String normalizedRole = userRepository.count() == 0 ? "admin" : "enthusiast";
        String displayName = request.name() == null || request.name().isBlank()
                ? request.email().split("@")[0]
                : request.name();
        User user = new User();
        user.setName(displayName);
        user.setEmail(request.email());
        user.setPassword(request.password());
        user.setRole(normalizedRole);
        User saved = userRepository.save(user);
        return new LoginResponse(
                jwtUtil.generateToken(saved.getEmail(), saved.getRole(), saved.getName()),
                saved.getRole()
        );
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password"));
        if (!user.getPassword().equals(request.password())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password");
        }
        String normalizedRole = normalizeRole(user.getRole());
        if (!normalizedRole.equals(user.getRole())) {
            user.setRole(normalizedRole);
            user = userRepository.save(user);
        }
        return new LoginResponse(
                jwtUtil.generateToken(user.getEmail(), user.getRole(), user.getName()),
                user.getRole()
        );
    }

    public List<User> getAllUsers() { return userRepository.findAll(); }

    public User updateRole(Long id, String role) {
        User user = userRepository.findById(id).orElseThrow();
        user.setRole(normalizeRole(role));
        return userRepository.save(user);
    }

    public User getCurrentUser() {
        return userRepository.findAll().stream().findFirst().orElseThrow();
    }

    private String normalizeRole(String role) {
        if (role == null) {
            return "enthusiast";
        }
        String value = role.trim().toLowerCase();
        return switch (value) {
            case "admin", "creator", "guide", "enthusiast" -> value;
            case "user" -> "enthusiast";
            default -> "enthusiast";
        };
    }
}
