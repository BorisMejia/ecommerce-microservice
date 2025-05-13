package com.microservice.auth.application.ports;

import com.microservice.auth.domain.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserRepositoryPort  {

    Mono<User> save(User user);
    Mono<User> getUserById(UUID idUser);

    Mono<User> getUserByEmail(String emailUser);

    Flux<User> findAll();

    Mono<User>updateUser(User user, UUID idUser);

    Mono<Void> deleteById(UUID idUser);


}
