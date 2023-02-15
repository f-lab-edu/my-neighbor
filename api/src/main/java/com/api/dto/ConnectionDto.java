package com.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ConnectionDto {

    private Long groupId;

    private Long userId;

    @Override
    public String toString() {
        return "GroupJoinRequest{" +
                "groupId=" + groupId +
                ", userId=" + userId +
                '}';
    }
}
