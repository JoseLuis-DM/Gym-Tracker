package com.gym.tracker.session.infrastructure.repository;

import com.gym.tracker.session.infrastructure.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringSessionRepository extends JpaRepository<
        SessionEntity, Long>,
        JpaSpecificationExecutor<SessionEntity>
{
    List<SessionEntity> findByUserId(Long userId);
}
