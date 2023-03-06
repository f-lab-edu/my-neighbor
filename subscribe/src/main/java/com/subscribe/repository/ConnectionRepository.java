package com.subscribe.repository;

import com.subscribe.model.Connection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnectionRepository extends JpaRepository<Connection, Long> {

    Connection save(Connection connection);
}
