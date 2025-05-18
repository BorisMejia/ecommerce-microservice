package com.microservice.auth.application.service;


import com.microservice.auth.application.ports.UserRepositoryPort;
import com.microservice.auth.application.service.usecase.*;
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

    private final CreateUser createUser;
    private final GetUserById getUserById;
    private final GetUserByEmail getUserByEmail;
    private final GetAllUser getAllUser;
    private final UpdateUser updateUser;
    private final DeleteUser deleteById;

    public Mono<User> createUser(User user){
        return createUser.save(user);
    }
    public Mono<User>getUserById(UUID idUser){
        return getUserById.getUserById(idUser);
    }
    public Mono<User>getUserByEmail(String emailUser){
        return getUserByEmail.getUserByEmail(emailUser);
    }
    public Flux<User>getAllUser(){
        return getAllUser.findAll();
    }
    public Mono<User>updateUser(User user, UUID idUser){
        return updateUser.updateUser(user, idUser);
    }
    public Mono<Void>deleteById(UUID idUser){
        return deleteById.deleteById(idUser);
    }

}
