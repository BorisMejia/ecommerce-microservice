package com.microservice.auth.application.service.usecase;

import com.microservice.auth.domain.model.User;
import reactor.core.publisher.Mono;

public interface CreateUser
{
    Mono<User> save(User user);
}
