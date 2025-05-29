package com.microservice.auth.shared.dto;

public record AuthResponse(

        String token,
        String email
) {
}
