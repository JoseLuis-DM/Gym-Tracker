package com.gym.tracker.set.infrastructure.repository;

import com.gym.tracker.exercise.infrastructure.entity.ExerciseEntity;
import com.gym.tracker.exercise.infrastructure.repository.SpringExerciseRepository;
import com.gym.tracker.set.domain.Set;
import com.gym.tracker.set.domain.SetRepository;
import com.gym.tracker.set.infrastructure.mapper.SetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SetRepositoryImpl implements SetRepository {

    private final SpringSetRepository springSetRepository;
    private final SpringExerciseRepository springExerciseRepository;
    private final SetMapper setMapper;

    @Override
    public Set save(Set set) {
        ExerciseEntity exerciseEntity = springExerciseRepository.getReferenceById(set.getExerciseId());

        return setMapper.toSet(
                springSetRepository.save(setMapper.toSetEntity(set, exerciseEntity))
        );
    }

    @Override
    public Optional<Set> findById(Long id) {
        return springSetRepository.findById(id)
                .map(setMapper::toSet);
    }

    @Override
    public List<Set> findAll() {
        return springSetRepository.findAll()
                .stream().map(setMapper::toSet).toList();
    }

    @Override
    public void deleteById(Long id) {
        springSetRepository.deleteById(id);
    }

    @Override
    public List<Set> findByExerciseId(Long exerciseId) {
        return springSetRepository.findByExerciseId(exerciseId)
                .stream().map(setMapper::toSet).toList();
    }
}
