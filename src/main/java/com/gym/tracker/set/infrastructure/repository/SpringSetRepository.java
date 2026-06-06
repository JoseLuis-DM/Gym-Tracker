package com.gym.tracker.set.infrastructure.repository;

import com.gym.tracker.set.infrastructure.entity.SetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringSetRepository extends JpaRepository<SetEntity, Long> {

    List<SetEntity> findByExerciseId(Long exerciseId);
}