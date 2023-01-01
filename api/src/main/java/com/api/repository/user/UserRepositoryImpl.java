package com.api.repository.user;

import com.api.model.user.User;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public User insert(User user) {
        return null;
    }

    @Override
    public Optional<User> findById(Long userId) {
        return Optional.empty();
    }
}
