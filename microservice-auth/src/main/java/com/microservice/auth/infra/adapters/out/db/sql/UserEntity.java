package com.microservice.auth.infra.adapters.out.db.sql;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("users")
public class UserEntity {

    @Id
    private UUID idUser;
    private String nameUser;
    private String emailUser;
    private String passUser;
    private String rol;
}
