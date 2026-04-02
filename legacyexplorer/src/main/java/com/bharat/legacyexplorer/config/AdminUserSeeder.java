package com.bharat.legacyexplorer.config;

import com.bharat.legacyexplorer.model.User;
import com.bharat.legacyexplorer.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminUserSeeder {

    @Bean
    CommandLineRunner seedAdminUser(UserRepository userRepository) {
        return args -> {
            String adminEmail = "admin@bharat.com";
            if (userRepository.findByEmail(adminEmail).isEmpty()) {
                User admin = new User();
                admin.setName("Admin");
                admin.setEmail(adminEmail);
                admin.setPassword("1234556");
                admin.setRole("admin");
                userRepository.save(admin);
            }
        };
    }
}
