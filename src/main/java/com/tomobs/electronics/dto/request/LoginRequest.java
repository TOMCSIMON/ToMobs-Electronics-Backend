package com.tomobs.electronics.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @Email(message = "Please enter proper email")
    @NotBlank(message = "Please enter email")
    private String email;

    @NotBlank(message = "Please enter password")
    private String password;
}
