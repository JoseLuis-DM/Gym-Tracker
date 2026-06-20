package com.gym.tracker.session.infrastructure.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record SessionDTO(
        Long id,

        @NotNull(message = "User id is required")
        Long userId,

        @NotNull(message = "Date is required")
        LocalDate date,

        String notes
) {
}
