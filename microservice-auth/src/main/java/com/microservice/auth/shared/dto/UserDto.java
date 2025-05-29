package com.microservice.auth.shared.dto;

import java.util.UUID;

public record UserDto(
        UUID id,
        String userName,
        String email
) {
}
