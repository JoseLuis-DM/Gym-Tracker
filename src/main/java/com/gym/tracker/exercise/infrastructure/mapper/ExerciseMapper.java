package com.gym.tracker.exercise.infrastructure.mapper;

import com.gym.tracker.exercise.domain.Exercise;
import com.gym.tracker.exercise.infrastructure.entity.ExerciseEntity;
import com.gym.tracker.session.infrastructure.entity.SessionEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, builder = @Builder(disableBuilder = true))
public interface ExerciseMapper {

    @Mapping(target = "sessionId", source = "session.id")
    Exercise toExercise(ExerciseEntity exerciseEntity);

    @Mapping(target = "session", source = "session")
    ExerciseEntity toExerciseEntity(Exercise exercise, SessionEntity sessionEntity);
}