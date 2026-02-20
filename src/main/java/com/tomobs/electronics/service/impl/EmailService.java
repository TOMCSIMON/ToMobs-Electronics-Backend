package com.tomobs.electronics.service.impl;

import com.tomobs.electronics.utils.OtpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    public String sendOtpEmail(String toEmail) {
        String otp = OtpUtil.generateOtp(6);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("OTP Code");
        message.setText("OTP is : " + otp + "will expire in 5 minutes.");
        javaMailSender.send(message);
        return otp;
    }
}
