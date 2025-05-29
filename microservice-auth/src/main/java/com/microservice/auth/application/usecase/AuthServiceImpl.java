package com.microservice.auth.application.usecase;

import com.microservice.auth.application.service.AuthService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AuthUseCase {

    private AuthService authService;

    public Mono<Auth>
}
