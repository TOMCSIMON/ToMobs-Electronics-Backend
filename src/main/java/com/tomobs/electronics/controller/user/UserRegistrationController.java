package com.tomobs.electronics.controller.user;

import com.tomobs.electronics.dto.request.UserRegistrationDTO;
import com.tomobs.electronics.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserRegistrationController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {

        System.out.println("Reached Backend");
        System.out.println();
        System.out.println();
        userService.registerUser(userRegistrationDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
