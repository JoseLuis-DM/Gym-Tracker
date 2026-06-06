package com.gym.tracker.user.domain;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findById(Long id);

    List<User> findAll();

    Optional<User> findByEmail(String email);

    boolean emailExist(String email);

    void deleteById(Long id);
}
