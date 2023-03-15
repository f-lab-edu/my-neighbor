package com.nb.command.mapper;

import com.nb.command.dto.ConnectionDto;
import com.nb.core.model.connection.Connection;

public class ConnectionMapper {

    public static Connection toEntity(ConnectionDto dto) {
        return new Connection(dto.getGroupId(), dto.getUserId());
    }
}
