package com.gym.tracker.exercise.infrastructure.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ExerciseDTO(
        Long id,

        @NotNull(message = "Session id is required")
        Long sessionId,

        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Muscle group is required")
        String muscleGroup
) {
}