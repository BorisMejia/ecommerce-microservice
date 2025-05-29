package com.microservice.auth.domain.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private UUID idUser;
    private String userName;
    private String email;
    private String password;
}
