package com.gym.tracker.exercise.infrastructure.entity;

import com.gym.tracker.audit.Auditable;
import com.gym.tracker.session.infrastructure.entity.SessionEntity;
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
@Table(name = "exercises")
public class ExerciseEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false)
    private SessionEntity session;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String muscleGroup;
}
