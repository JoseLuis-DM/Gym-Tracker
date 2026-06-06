package com.gym.tracker.exercise.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Exercise {

    private Long id;

    private Long sessionId;

    private String name;

    private String muscleGroup;
}