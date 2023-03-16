package com.nb.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SimpleGroupDto {

    private Long groupId;

    @Override
    public String toString() {
        return "SimpleGroupDto{" +
                "groupId=" + groupId +
                '}';
    }
}
