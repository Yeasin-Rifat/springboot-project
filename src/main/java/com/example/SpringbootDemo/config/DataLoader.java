package com.example.SpringbootDemo.config;

import com.example.SpringbootDemo.entity.User;
import com.example.SpringbootDemo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("intern").isEmpty()) {
            User internUser = new User("intern", passwordEncoder.encode("password123"), "USER");
            userRepository.save(internUser);
        }

        if (userRepository.findByUsername("admin").isEmpty()) {
            User adminUser = new User("admin", passwordEncoder.encode("admin123"), "ADMIN");
            userRepository.save(adminUser);
        }
    }
}
