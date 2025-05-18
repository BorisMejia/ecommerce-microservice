package com.microservice.auth.application.service.usecase;

import com.microservice.auth.domain.model.User;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface GetUserById {

    Mono<User> getUserById(UUID idUser);

}
