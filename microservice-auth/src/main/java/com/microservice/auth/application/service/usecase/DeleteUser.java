package com.microservice.auth.application.service.usecase;

import reactor.core.publisher.Mono;

import java.util.UUID;

public interface DeleteUser {

    Mono<Void> deleteById(UUID idUser);
}
