package com.gym.tracker.set.domain;

import java.util.List;
import java.util.Optional;

public interface SetRepository {

    Set save(Set set);

    Optional<Set> findById(Long id);

    List<Set> findAll();

    void deleteById(Long id);

    List<Set> findByExerciseId(Long exerciseId);
}
