package com.microservice.auth.application.service;


import com.microservice.auth.domain.model.User;
import reactor.core.publisher.Mono;

public interface AuthService {

    Mono<User> registerUser(String userName, String email, String password);
    Mono<User> login(String email, String password);

}
