package com.tomobs.electronics.controller.user;

import com.tomobs.electronics.dto.request.UserRegistrationDTO;
import com.tomobs.electronics.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserRegistrationController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {

        userService.registerUser(userRegistrationDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
