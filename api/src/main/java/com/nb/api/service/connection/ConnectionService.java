package com.nb.api.service.connection;

import com.nb.core.error.GroupNotFoundException;
import com.nb.core.error.UserNotFoundException;
import com.nb.core.model.connection.Connection;
import com.nb.core.model.group.Group;
import com.nb.core.model.user.User;
import com.nb.core.repository.connection.ConnectionRepository;
import com.nb.core.repository.group.GroupRepository;
import com.nb.core.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ConnectionService {

    private final ConnectionRepository connectionRepository;

    private final GroupRepository groupRepository;

    private final UserRepository userRepository;

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
        Connection res = connectionRepository.findByGroupIdAndUserId(connection.getGroupId(), connection.getUserId()).orElseThrow(RuntimeException::new);
        connectionRepository.deleteById(res.getConnectionId());
        return res;
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
}
