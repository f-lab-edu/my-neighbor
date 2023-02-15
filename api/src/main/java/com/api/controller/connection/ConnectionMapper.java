package com.api.controller.connection;

import com.api.dto.ConnectionDto;
import com.api.model.connection.Connection;

public class ConnectionMapper {

    public static Connection toEntity(ConnectionDto dto) {
        return new Connection(dto.getGroupId(), dto.getUserId());
    }

    public static ConnectionDto toDto(Connection conn) {
        return new ConnectionDto(conn.getGroupId(), conn.getUserId());
    }
}
