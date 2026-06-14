package com.gym.tracker.user.infrastructure.mapper;

import com.gym.tracker.user.domain.User;
import com.gym.tracker.user.infrastructure.entity.UserEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, builder = @Builder(disableBuilder = true))
public interface UserMapper {

    User toUser(UserEntity userEntity);

    UserEntity toUserEntity(User user);
}