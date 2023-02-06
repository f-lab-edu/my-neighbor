package com.api.service.user;

import com.api.error.NotFoundException;
import com.api.model.user.User;
import com.api.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

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

    public List<User> findAllByUserIdList(List<Long> list) {
        return list.stream()
                .map(r -> findById(r).orElseThrow(() -> new NotFoundException(User.class, r)))
                .collect(toList());
    }

}
