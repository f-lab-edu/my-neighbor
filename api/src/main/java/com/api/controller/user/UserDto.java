package com.api.controller.user;

import com.api.model.user.User;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.StringJoiner;

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
        BeanUtils.copyProperties(source, this);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getTownId() {
        return townId;
    }

    public void setTownId(Long townId) {
        this.townId = townId;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public LocalDateTime getLastLoginAt() {
        return lastLoginAt;
    }

    public void setLastLoginAt(LocalDateTime lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserDto.class.getSimpleName() + "[", "]")
                .add("userId=" + userId)
                .add("email='" + email + "'")
                .add("name='" + name + "'")
                .add("cityId=" + cityId)
                .add("townId=" + townId)
                .add("profileImageUrl='" + profileImageUrl + "'")
                .add("lastLoginAt=" + lastLoginAt)
                .add("createAt=" + createAt)
                .toString();
    }
}
