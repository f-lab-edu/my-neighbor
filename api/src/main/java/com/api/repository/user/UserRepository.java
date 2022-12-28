package com.api.repository.user;

import com.api.model.user.User;

import java.util.Optional;

public interface UserRepository {

    // join
    User insert(User user);

    // search
    Optional<User> findById(Long userId);

}
