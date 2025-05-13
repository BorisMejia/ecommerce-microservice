package com.microservice.auth.infra.adapters.out.repository;

import com.microservice.auth.infra.adapters.out.db.sql.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;


public interface UserRepositoryR2dbc extends ReactiveCrudRepository<UserEntity, UUID> {
    Mono<UserEntity> findByEmailUser(String emailUser);
    Mono<UserEntity> findByIdUser(UUID idUser);
}
