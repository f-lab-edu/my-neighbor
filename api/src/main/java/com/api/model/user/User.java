package com.api.model.user;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

// todo lombok..?
public class User {

    private Long userId;

    private String email;

    private String name;

    private String password;

    private Long cityId;

    private Long townId;

    private String profileImageUrl;

    private LocalDateTime lastLoginAt;

    private LocalDateTime createAt;

    public User(String email, String name, String password) {
        this(null, email, name, password, null, null, null, null, null);
    }

    public User(Long userId, String email, String name, String password, Long cityId, Long townId, String profileImageUrl, LocalDateTime lastLoginAt, LocalDateTime createAt) {
        // todo validation

        this.userId = userId;
        this.email = email;
        this.name = name;
        this.password = password;
        this.cityId = cityId;
        this.townId = townId;
        this.profileImageUrl = profileImageUrl;
        this.lastLoginAt = lastLoginAt;
        this.createAt = createAt;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Long getCityId() {
        return cityId;
    }

    public Long getTownId() {
        return townId;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public LocalDateTime getLastLoginAt() {
        return lastLoginAt;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return userId != null ? userId.hashCode() : 0;
    }

    // todo builder

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
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
