package com.api.dto.user;

import com.api.model.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserDto {

    private Long userId;

    private String email;

    private String name;

    private Long cityId;

    private Long townId;

    private String profileImageUrl;

    private LocalDateTime lastLoginAt;

    private LocalDateTime createAt;

    public UserDto(User source) {
        this.userId = source.getUserId();
        this.email = source.getEmail();
        this.name = source.getName();
        this.cityId = source.getCityId();
        this.townId = source.getTownId();
        this.profileImageUrl = source.getProfileImageUrl();
        this.lastLoginAt = source.getLastLoginAt();
        this.createAt = source.getCreateAt();
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", cityId=" + cityId +
                ", townId=" + townId +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                ", lastLoginAt=" + lastLoginAt +
                ", createAt=" + createAt +
                '}';
    }
}
