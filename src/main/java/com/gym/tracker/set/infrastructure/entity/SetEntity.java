package com.gym.tracker.set.infrastructure.entity;

import com.gym.tracker.audit.Auditable;
import com.gym.tracker.exercise.infrastructure.entity.ExerciseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sets")
public class SetEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    private ExerciseEntity exercise;

    @Column(nullable = false)
    private Integer reps;

    @Column(nullable = false)
    private Integer weightKg;

    @Column(nullable = false)
    private Integer setNumber;
}
