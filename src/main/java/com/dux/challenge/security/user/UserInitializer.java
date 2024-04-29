package com.dux.challenge.security.user;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserInitializer {

    private final UserService userService;

    @PostConstruct
    public void init() {
        userService.saveUser();
    }
}
