package com.microservice.auth.infra.adapters.out.db.sql.mapper;

import com.microservice.auth.domain.model.User;
import com.microservice.auth.infra.adapters.out.db.sql.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toDomain(UserEntity entity);

    UserEntity toEntity(User domain);

    List<User> toDomainList(List<UserEntity> entityList);
    List<UserEntity> toEntityList(List<User> domainList);
}
