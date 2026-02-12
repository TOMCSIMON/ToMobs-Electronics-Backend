package com.tomobs.electronics.service.impl;

import com.tomobs.electronics.dto.request.UserRegistrationDTO;
import com.tomobs.electronics.enums.RoleEnum;
import com.tomobs.electronics.exception.RoleNotFoundException;
import com.tomobs.electronics.exception.UserAlreadyExistsException;
import com.tomobs.electronics.model.Role;
import com.tomobs.electronics.model.User;
import com.tomobs.electronics.repository.RoleRepository;
import com.tomobs.electronics.repository.UserRepository;
import com.tomobs.electronics.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public void registerUser(UserRegistrationDTO dto) {

        if(userRepository.existsByEmail(dto.getEmail())){
            throw new UserAlreadyExistsException("User Already Exists for this email " + dto.getEmail());
        }
        User user = mapper.map(dto, User.class);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        Role defaultRole = roleRepository.findByName(RoleEnum.ROLE_USER)
                        .orElseThrow(() -> new RoleNotFoundException("Role not found"));
        user.setRole(defaultRole);
        userRepository.save(user);
    }
}
