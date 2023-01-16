package com.api.service.user;

import com.api.model.user.User;
import com.api.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User join(String email, String name, String password) {
        return userRepository.insert(new User(email, name, password));
    }

    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }
}
