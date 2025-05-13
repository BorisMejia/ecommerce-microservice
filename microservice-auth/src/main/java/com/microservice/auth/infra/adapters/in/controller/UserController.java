package com.microservice.auth.infra.adapters.in.controller;

import com.microservice.auth.application.service.UserService;
import com.microservice.auth.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@AllArgsConstructor
@RestController("users")
public class UserController {

    private final UserService service;

    @PostMapping
    public Mono<User> createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable UUID id) {
        return service.getUserById(id);
    }
    @GetMapping("/{emailUser}")
    public Mono<User> getUserByEmail(@PathVariable String emailUser) {
        return service.getUserByEmail(emailUser);
    }

    @GetMapping
    public Flux<User> getAllUsers() {
        return service.getAllUser();
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable UUID id) {
        return service.deleteById(id);
    }
}
