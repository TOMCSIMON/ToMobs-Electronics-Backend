package com.tomobs.electronics.config;

import com.tomobs.electronics.enums.RoleEnum;
import com.tomobs.electronics.model.Role;
import com.tomobs.electronics.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String @NonNull ... args) {
        saveRoleIfNotFound(RoleEnum.ROLE_USER);
        saveRoleIfNotFound(RoleEnum.ROLE_ADMIN);
    }

    private void saveRoleIfNotFound(RoleEnum roleEnum) {
        if(!roleRepository.existsByName(roleEnum)) {
            Role role = new Role();
            role.setName(roleEnum);
            roleRepository.save(role);
        }
    }
}
