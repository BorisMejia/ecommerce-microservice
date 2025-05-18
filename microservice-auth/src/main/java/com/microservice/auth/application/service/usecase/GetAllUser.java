package com.microservice.auth.application.service.usecase;

import com.microservice.auth.domain.model.User;
import reactor.core.publisher.Flux;

public interface GetAllUser {
    Flux<User> findAll();

}
