package com.gym.tracker.session.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Session {

    private Long id;

    private Long userId;

    private LocalDate date;

    private String notes;
}