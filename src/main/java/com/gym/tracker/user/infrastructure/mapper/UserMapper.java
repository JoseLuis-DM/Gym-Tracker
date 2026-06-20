package com.gym.tracker.user.infrastructure.mapper;

import com.gym.tracker.user.domain.User;
import com.gym.tracker.user.infrastructure.dto.UserRequestDTO;
import com.gym.tracker.user.infrastructure.dto.UserResponseDTO;
import com.gym.tracker.user.infrastructure.dto.UserUpdateDTO;
import com.gym.tracker.user.infrastructure.entity.UserEntity;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, builder = @Builder(disableBuilder = true))
public interface UserMapper {

    User toUser(UserEntity userEntity);

    UserEntity toUserEntity(User user);

    UserResponseDTO toUserResponseDTO(User user);

    User toUser(UserRequestDTO userRequestDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    void updateUserFromDTO(UserUpdateDTO userUpdateDTO, @MappingTarget User user);
}