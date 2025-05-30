package com.microservice.auth.shared.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @Email
        String email,
        @NotBlank
        String password
) {
}
