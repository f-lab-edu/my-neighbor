package com.api.model.user;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = {"userId"})
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

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", cityId=" + cityId +
                ", townId=" + townId +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                ", lastLoginAt=" + lastLoginAt +
                ", createAt=" + createAt +
                '}';
    }
}
