package com.tomobs.electronics.service;

import com.tomobs.electronics.dto.request.UserRegistrationDTO;

public interface UserService {
    void registerUser(UserRegistrationDTO userRegistrationDTO);
}
