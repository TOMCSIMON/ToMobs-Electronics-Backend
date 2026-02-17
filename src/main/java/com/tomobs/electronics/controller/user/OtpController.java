package com.tomobs.electronics.controller.user;

import com.tomobs.electronics.service.impl.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class OtpController {

    private final EmailService emailService;

    @PostMapping("/otp")
    public ResponseEntity<String> sendOtp(@RequestParam String email) {

        String otp = emailService.sendOtpEmail(email);
        return ResponseEntity.ok("OTP :" +otp  +"sent to " + email);
    }
}
