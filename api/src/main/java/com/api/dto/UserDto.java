package com.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class UserDto {

    private Long userId;

    private String email;

    private String name;

    private Integer regionId;

    private String profileImageUrl;

    private LocalDateTime lastLoginAt;

    private LocalDateTime createAt;

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", regionId=" + regionId +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                ", lastLoginAt=" + lastLoginAt +
                ", createAt=" + createAt +
                '}';
    }
}
