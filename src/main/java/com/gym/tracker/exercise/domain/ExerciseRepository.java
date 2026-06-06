package com.gym.tracker.exercise.domain;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository {

    Exercise save(Exercise exercise);

    Optional<Exercise> findById(Long id);

    List<Exercise> findAll();

    void deleteById(Long id);

    List<Exercise> findBySessionId(Long sessionId);
}
