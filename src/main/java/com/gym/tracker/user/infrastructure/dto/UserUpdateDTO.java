package com.gym.tracker.user.infrastructure.dto;

import jakarta.validation.constraints.Email;
import lombok.Builder;

@Builder
public record UserUpdateDTO(
        @Email(message = "Email must be valid")
        String email,

        String name
) {
}