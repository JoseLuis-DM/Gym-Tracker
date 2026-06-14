package com.gym.tracker.exercise.infrastructure.repository;

import com.gym.tracker.exercise.domain.Exercise;
import com.gym.tracker.exercise.domain.ExerciseRepository;
import com.gym.tracker.exercise.infrastructure.mapper.ExerciseMapper;
import com.gym.tracker.session.infrastructure.entity.SessionEntity;
import com.gym.tracker.session.infrastructure.repository.SpringSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ExerciseRepositoryImpl implements ExerciseRepository {

    private final SpringExerciseRepository springExerciseRepository;
    private final SpringSessionRepository springSessionRepository;
    private final ExerciseMapper exerciseMapper;

    @Override
    public Exercise save(Exercise exercise) {
        SessionEntity sessionEntity = springSessionRepository.getReferenceById(exercise.getSessionId());

        return exerciseMapper.toExercise(
                springExerciseRepository.save(exerciseMapper.toExerciseEntity(exercise, sessionEntity))
        );
    }

    @Override
    public Optional<Exercise> findById(Long id) {
        return springExerciseRepository.findById(id)
                .map(exerciseMapper::toExercise);
    }

    @Override
    public List<Exercise> findAll() {
        return springExerciseRepository.findAll()
                .stream().map(exerciseMapper::toExercise).toList();
    }

    @Override
    public void deleteById(Long id) {
        springExerciseRepository.deleteById(id);
    }

    @Override
    public List<Exercise> findBySessionId(Long sessionId) {
        return springExerciseRepository.findBySessionId(sessionId)
                .stream().map(exerciseMapper::toExercise).toList();
    }
}
