package com.microservice.auth.application.ports;

import com.microservice.auth.application.service.UserService;
import com.microservice.auth.application.service.usecase.*;
import com.microservice.auth.domain.model.User;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserRepositoryPort extends CreateUser, GetAllUser, GetUserById, GetUserByEmail, UpdateUser, DeleteUser  {

}
