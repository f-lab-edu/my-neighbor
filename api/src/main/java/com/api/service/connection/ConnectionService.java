package com.api.service.connection;

import com.api.error.GroupNotFoundException;
import com.api.error.UserNotFoundException;
import com.api.model.connection.Connection;
import com.api.model.group.Group;
import com.api.model.user.User;
import com.api.repository.connection.ConnectionRepository;
import com.api.repository.group.GroupRepository;
import com.api.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ConnectionService {

    private final ConnectionRepository connectionRepository;

    private final GroupRepository groupRepository;

    private final UserRepository userRepository;

    private final Clock clock;

    @Transactional
    public Connection saveConnection(Connection connection) {
        Long groupId = connection.getGroupId();
        Long userId = connection.getUserId();

        checkGroupByGroupId(groupId);
        checkUserByUserId(userId);

        if(findByGroupIdAndUserId(groupId, userId).isPresent()) return connection;

        connection.updateCreateAt(clock);
        return connectionRepository.save(connection);
    }

    public List<Long> findAllByGroupId(Long groupId) {
        List<Connection> res = connectionRepository.findAllByGroupId(groupId);
        return res.stream().map(Connection::getUserId).collect(toList());
    }

    public List<Long> findAllByUserId(Long userId) {
        List<Connection> res = connectionRepository.findAllByUserId(userId);
        return res.stream().map(Connection::getGroupId).collect(toList());
    }

    @Transactional
    public Connection deleteConnection(Connection connection) {
        checkGroupByGroupId(connection.getGroupId());
        checkUserByUserId(connection.getUserId());

        connectionRepository.delete(connection);
        return connection;
    }

    public Optional<Connection> findByGroupIdAndUserId(Long groupId, Long userId) {
        return connectionRepository.findByGroupIdAndUserId(groupId, userId);
    }

    public List<Group> findByGroupIdIn(List<Long> list) {
        List<Group> res = groupRepository.findByGroupIdIn(list);
        if(res.size() != list.size()) throw new GroupNotFoundException("Group not found.");
        return res;
    }

    public List<User> findByUserIdIn(List<Long> list) {
        List<User> res = userRepository.findByUserIdIn(list);
        if(res.size() != list.size()) throw new UserNotFoundException("User not found.");
        return res;
    }
    
    public void checkGroupByGroupId(Long groupId) {
        groupRepository.findById(groupId).orElseThrow(GroupNotFoundException::new);
    }

    public void checkUserByUserId(Long userId) {
        userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }
}
