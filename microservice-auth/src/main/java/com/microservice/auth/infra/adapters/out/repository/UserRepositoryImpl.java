package com.microservice.auth.infra.adapters.out.repository;

import com.microservice.auth.application.ports.UserRepositoryPort;
import com.microservice.auth.domain.model.User;
import com.microservice.auth.infra.adapters.out.db.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryPort {

    private final UserRepositoryR2dbc repositoryR2dbc;
    private final UserMapper mapper;

    @Override
    public Mono<User> save(User user) {
        return repositoryR2dbc.save(mapper.toEntity(user))
                .map(mapper::toDomain);
    }

    @Override
    public Mono<User> getUserById(UUID idUser) {
        return repositoryR2dbc.findByIdUser(idUser)
                .map(mapper::toDomain);
    }

    @Override
    public Mono<User> getUserByEmail(String emailUser) {
        return repositoryR2dbc.findByEmailUser(emailUser)
                .map(mapper::toDomain);
    }

    @Override
    public Flux<User> findAll() {
        return repositoryR2dbc.findAll()
                .map(mapper::toDomain);
    }

    @Override
    public Mono<User> updateUser(User user, UUID idUser) {
        return repositoryR2dbc.findByIdUser(idUser)
                .flatMap(existing -> {
                    existing.setNameUser(user.getNameUser());
                    existing.setEmailUser(user.getEmailUser());
                    existing.setPassUser(user.getPassUser());
                    existing.setRol(user.getRol());
                    return repositoryR2dbc.save(existing);
                })
                .map(mapper::toDomain);


    }

    @Override
    public Mono<Void> deleteById(UUID idUser) {
        return repositoryR2dbc.deleteById(idUser);
    }
}
