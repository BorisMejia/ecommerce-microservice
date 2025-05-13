package com.microservice.auth.infra.adapters.out.event.dto;

import java.util.UUID;

public class UserCreatedEvent {

    private UUID idUser;
    private String nameUser;
    private String emailUser;
    private String role;
}
