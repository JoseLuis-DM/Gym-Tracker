package com.gym.tracker.set.infrastructure.mapper;

import com.gym.tracker.exercise.infrastructure.entity.ExerciseEntity;
import com.gym.tracker.set.domain.Set;
import com.gym.tracker.set.infrastructure.dto.SetDTO;
import com.gym.tracker.set.infrastructure.entity.SetEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, builder = @Builder(disableBuilder = true))
public interface SetMapper {

    @Mapping(target = "exerciseId", source = "exercise.id")
    Set toSet(SetEntity setEntity);

    @Mapping(target = "exercise", source = "exercise")
    SetEntity toSetEntity(Set set, ExerciseEntity exerciseEntity);

    Set toSet(SetDTO setDTO);

    SetDTO toSetDTO(Set set);
}
