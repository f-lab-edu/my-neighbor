package com.subscribe.mapper;


import com.subscribe.dto.ConnectionDto;
import com.subscribe.model.Connection;

public class ConnectionMapper {

    public static Connection toEntity(ConnectionDto dto) {
        return new Connection(dto.getGroupId(), dto.getUserId());
    }
}
