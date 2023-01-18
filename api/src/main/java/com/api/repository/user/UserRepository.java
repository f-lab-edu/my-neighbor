package com.api.repository.user;

import com.api.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // join
    User save(User user);

    // search
    Optional<User> findById(Long userId);
}
