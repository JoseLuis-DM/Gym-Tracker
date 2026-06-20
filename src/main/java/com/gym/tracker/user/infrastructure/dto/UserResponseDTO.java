package com.gym.tracker.user.infrastructure.dto;

import lombok.Builder;

@Builder
public record UserResponseDTO(
        Long id,
        String email,
        String name
) {
}