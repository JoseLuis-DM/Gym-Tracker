package com.gym.tracker.set.infrastructure.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record SetDTO(
        Long id,

        @NotNull(message = "Exercise is required")
        Long exerciseId,

        @NotNull(message = "Reps is required")
        @Min(value = 1, message = "Reps must be at least 1")
        Integer reps,

        @NotNull(message = "Wight is required")
        @Min(value = 0, message = "Weight cannot be negative")
        Integer weightKg,

        @NotNull(message = "Set number is required")
        @Min(value = 1, message = "Set number must be a least 1")
        Integer setNumber
) {
}
