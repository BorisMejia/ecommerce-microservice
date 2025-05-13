package com.microservice.auth.application.service;


import com.microservice.auth.application.ports.UserRepositoryPort;
import com.microservice.auth.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepositoryPort userRepositoryPort;

    public Mono<User> createUser(User user){
        return userRepositoryPort.save(user);
    }
    public Mono<User>getUserById(UUID idUser){
        return userRepositoryPort.getUserById(idUser);
    }
    public Mono<User>getUserByEmail(String emailUser){
        return userRepositoryPort.getUserByEmail(emailUser);
    }
    public Flux<User>getAllUser(){
        return userRepositoryPort.findAll();
    }
    public Mono<User>updateUser(User user, UUID idUser){
        return userRepositoryPort.updateUser(user, idUser);
    }
    public Mono<Void>deleteById(UUID idUser){
        return userRepositoryPort.deleteById(idUser);
    }

}
