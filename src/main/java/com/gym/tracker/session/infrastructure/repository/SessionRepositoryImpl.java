package com.gym.tracker.session.infrastructure.repository;

import com.gym.tracker.session.domain.Session;
import com.gym.tracker.session.domain.SessionRepository;
import com.gym.tracker.session.infrastructure.mapper.SessionMapper;
import com.gym.tracker.user.infrastructure.entity.UserEntity;
import com.gym.tracker.user.infrastructure.repository.SpringUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SessionRepositoryImpl implements SessionRepository {

    private final SpringSessionRepository springSessionRepository;
    private final SpringUserRepository springUserRepository;
    private final SessionMapper sessionMapper;

    @Override
    public Session save(Session session) {
        UserEntity userEntity = springUserRepository.getReferenceById(session.getUserId());

        return sessionMapper.toSession(
                springSessionRepository.save(sessionMapper.toSessionEntity(session, userEntity))
        );
    }

    @Override
    public Optional<Session> findById(Long id) {
        return springSessionRepository.findById(id)
                .map(sessionMapper::toSession);
    }

    @Override
    public List<Session> findAll() {
        return springSessionRepository.findAll()
                .stream().map(sessionMapper::toSession).toList();
    }

    @Override
    public void deleteById(Long id) {
        springSessionRepository.deleteById(id);
    }

    @Override
    public List<Session> findByUserId(Long userId) {
        return springSessionRepository.findByUserId(userId)
                .stream().map(sessionMapper::toSession).toList();
    }
}
