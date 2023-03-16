package com.nb.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionDto {

    private Long groupId;

    private Long userId;

    @Override
    public String toString() {
        return "ConnectionDto{" +
                "groupId=" + groupId +
                ", userId=" + userId +
                '}';
    }
}
