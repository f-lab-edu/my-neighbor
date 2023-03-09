package com.nb.api.service.user;

import com.nb.core.model.user.User;
import com.nb.core.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User join(String email, String name, String password) {
        return userRepository.save(new User(email, name, password));
    }

    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }
}
