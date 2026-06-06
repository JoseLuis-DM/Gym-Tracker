package com.gym.tracker.session.domain;


import java.util.List;
import java.util.Optional;

public interface SessionRepository {

    Session save(Session session);

    Optional<Session> findById(Long id);

    List<Session> findAll();

    void deleteById(Long id);

    List<Session> findByUserId(Long userId);
}
