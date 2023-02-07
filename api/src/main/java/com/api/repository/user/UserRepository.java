package com.api.repository.user;

import com.api.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    Optional<User> findById(Long userId);

    @Query("SELECT u FROM User u WHERE u.userId IN (:userIds)")
    List<User> findAllByUserIds(@Param("userIds") List<Long> userIdList);

}
