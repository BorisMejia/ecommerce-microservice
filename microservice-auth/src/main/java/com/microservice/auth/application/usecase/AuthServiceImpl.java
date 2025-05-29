package com.microservice.auth.application.usecase;

import com.microservice.auth.application.service.AuthService;
import com.microservice.auth.domain.model.User;
import com.microservice.auth.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Mono<User> registerUser(String userName, String email, String password) {
        return null;
    }

    @Override
    public Mono<User> login(String email, String password) {
        return null;
    }
}
