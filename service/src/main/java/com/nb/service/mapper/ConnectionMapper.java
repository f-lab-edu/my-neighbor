package com.nb.service.mapper;

import com.nb.service.dto.ConnectionDto;
import com.nb.core.model.connection.Connection;

public class ConnectionMapper {

    public static Connection toEntity(ConnectionDto dto) {
        return new Connection(dto.getGroupId(), dto.getUserId());
    }
}
