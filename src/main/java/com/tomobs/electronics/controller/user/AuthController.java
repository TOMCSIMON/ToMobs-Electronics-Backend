package com.tomobs.electronics.controller.user;

import com.tomobs.electronics.dto.request.LoginRequest;
import com.tomobs.electronics.dto.response.JwtResponse;
import com.tomobs.electronics.security.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody @Valid LoginRequest loginRequest) {

        return ResponseEntity.ok(authService.loginUser(loginRequest));
    }
}
