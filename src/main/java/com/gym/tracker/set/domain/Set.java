package com.gym.tracker.set.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Set {

    private Long id;

    private Long exerciseId;

    private Integer reps;

    private Integer weightKg;

    private Integer setNumber;
}