package com.nb.core.repository.connection;

import com.nb.core.model.connection.Connection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConnectionRepository extends JpaRepository<Connection, Long> {

    Connection save(Connection connection);

    List<Connection> findAllByGroupId(Long groupId);

    List<Connection> findAllByUserId(Long userId);

    Optional<Connection> findByGroupIdAndUserId(Long groupId, Long userId);

    void delete(Connection connection);
}
