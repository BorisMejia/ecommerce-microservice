package com.microservice.auth.infra.adapters.out.db.mapper;

import com.microservice.auth.domain.model.User;
import com.microservice.auth.infra.adapters.out.db.sql.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toDomain(UserEntity entity);

    UserEntity toEntity(User domain);
}
