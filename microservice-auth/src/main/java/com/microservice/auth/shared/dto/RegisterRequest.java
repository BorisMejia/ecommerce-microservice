package com.microservice.auth.shared.dto;

public record RegisterRequest(
        String userName,
        String email,
        String password
) {
}
