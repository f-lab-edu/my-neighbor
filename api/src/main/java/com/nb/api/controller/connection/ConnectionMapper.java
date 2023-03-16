package com.nb.api.controller.connection;

import com.nb.api.dto.ConnectionDto;
import com.nb.core.model.connection.Connection;

public class ConnectionMapper {

    public static Connection toEntity(ConnectionDto dto) {
        return new Connection(dto.getGroupId(), dto.getUserId());
    }

    public static ConnectionDto toDto(Connection conn) {
        return new ConnectionDto(conn.getGroupId(), conn.getUserId());
    }
}
