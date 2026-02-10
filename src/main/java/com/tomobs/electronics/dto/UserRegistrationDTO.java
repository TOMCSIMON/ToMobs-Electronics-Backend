package com.tomobs.electronics.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationDTO {

    @NotBlank(message = "Name should not be blank")
    @Size(min = 2, max = 100)
    private String name;

    @NotBlank(message = "Email should not be blank")
    @Email
    private String email;

    @Size(min = 10, max = 15)
    private String phoneNumber;

    @NotBlank(message = "Password should not be blank")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;
}
