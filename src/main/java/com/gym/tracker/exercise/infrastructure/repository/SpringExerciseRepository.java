package com.gym.tracker.exercise.infrastructure.repository;

import com.gym.tracker.exercise.infrastructure.entity.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringExerciseRepository extends JpaRepository<
        ExerciseEntity, Long>,
        JpaSpecificationExecutor<ExerciseEntity>
{
    List<ExerciseEntity> findBySessionId(Long sessionId);

    @Query("SELECT e FROM ExerciseEntity e JOIN e.session s WHERE s.user.id = :userId AND e.name = :name ORDER BY s.date ASC")
    List<ExerciseEntity> findByUserIdAndNameOrderByDate(@Param("userId") Long userId, @Param("name") String name);
}
