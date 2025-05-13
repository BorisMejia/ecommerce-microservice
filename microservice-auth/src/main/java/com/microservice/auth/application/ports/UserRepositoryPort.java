package com.microservice.auth.application.ports;

import com.microservice.auth.domain.model.User;

import java.util.UUID;

public interface UserRepositoryPorts {

    User getUserById(UUID idUser);
}
