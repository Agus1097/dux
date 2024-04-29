package com.dux.challenge.security.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void saveUser() {
        User user = new User();
        user.setUsername("test");
        user.setPassword(passwordEncoder.encode("12345"));
        userRepository.save(user);
    }
}
