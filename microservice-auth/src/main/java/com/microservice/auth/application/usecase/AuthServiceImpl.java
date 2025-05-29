package com.microservice.auth.application.usecase;

import com.microservice.auth.application.service.AuthService;
import com.microservice.auth.domain.model.User;
import com.microservice.auth.domain.repository.UserRepository;
import com.microservice.auth.shared.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Mono<User> registerUser(String userName, String email, String password) {
        return userRepository.existsByEmail(email)
                .flatMap(exists -> {
                    if (exists) return Mono.error(new UserAlreadyExistsException(email));
                    UUID userId = UUID.randomUUID();
                    String paswordHash = passwordEncoder.encode(password);
                    User user = new User(userId, userName, email, paswordHash);
                    return userRepository.save(user);
                });
    }

    @Override
    public Mono<User> login(String email, String password) {
        return null;
    }
}
