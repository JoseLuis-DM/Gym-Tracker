package com.gym.tracker.session.infrastructure.mapper;

import com.gym.tracker.session.domain.Session;
import com.gym.tracker.session.infrastructure.dto.SessionDTO;
import com.gym.tracker.session.infrastructure.entity.SessionEntity;
import com.gym.tracker.user.infrastructure.entity.UserEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, builder = @Builder(disableBuilder = true))
public interface SessionMapper {

    @Mapping(target = "userId", source = "user.id")
    Session toSession(SessionEntity sessionEntity);

    @Mapping(target = "user", source = "user")
    SessionEntity toSessionEntity(Session session, UserEntity userEntity);

    Session toSession(SessionDTO sessionDTO);

    SessionDTO toSessionDTO(Session session);
}
