package com.gym.tracker.user.infrastructure.repository;

import com.gym.tracker.user.domain.User;
import com.gym.tracker.user.domain.UserRepository;
import com.gym.tracker.user.infrastructure.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final SpringUserRepository springUserRepository;
    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        return userMapper.toUser(
                springUserRepository.save(userMapper.toUserEntity(user))
        );
    }

    @Override
    public Optional<User> findById(Long id) {
        return springUserRepository.findById(id)
                .map(userMapper::toUser);
    }

    @Override
    public List<User> findAll() {
        return springUserRepository.findAll()
                .stream().map(userMapper::toUser).toList();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return springUserRepository.findByEmail(email)
                .map(userMapper::toUser);
    }

    @Override
    public boolean emailExist(String email) {
        return springUserRepository.existsByEmail(email);
    }

    @Override
    public void deleteById(Long id) {
        springUserRepository.deleteById(id);
    }
}
