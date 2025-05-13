package com.microservice.auth.infra.adapters.out.event.mapper;

import com.microservice.auth.domain.model.User;
import com.microservice.auth.infra.adapters.out.event.dto.UserCreatedEvent;
import com.microservice.auth.infra.adapters.out.event.dto.UserUpdateEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEventMapper {

    UserCreatedEvent toUserCreatedEvent(User user);

    UserUpdateEvent toUserUpdateEvent(User user);
}
