package com.microservice.auth.infra.adapters.in.rest;

import com.microservice.auth.application.service.AuthService;
import com.microservice.auth.infra.config.JwtProvider;
import com.microservice.auth.shared.dto.AuthResponse;
import com.microservice.auth.shared.dto.LoginRequest;
import com.microservice.auth.shared.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtProvider jwtProvider;

    @PostMapping("/register")
    public Mono<ResponseEntity<AuthResponse>> registerUser(@RequestBody RegisterRequest request){
        return authService.registerUser(request.userName(), request.email(), request.password())
                .map(user -> {
                    String token = jwtProvider.generateToken(user);
                    return ResponseEntity.ok(new AuthResponse(token, user.getUserName()));
                });
    }
    @PostMapping("/login")
    public Mono<ResponseEntity<AuthResponse>> loginUser(@RequestBody LoginRequest request){
        return authService.login(request.email(), request.password())
                .map(user -> {
                    String token = jwtProvider.generateToken(user);
                    return ResponseEntity.ok(new AuthResponse(token, user.getUserName()));
                });
    }
}
