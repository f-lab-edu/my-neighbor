package com.api.repository.user;

import com.api.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    Optional<User> findById(Long userId);
    
    List<User> findByUserIdIn(List<Long> userIdList);
}
