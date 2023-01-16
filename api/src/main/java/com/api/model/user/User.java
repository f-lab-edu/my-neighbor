package com.api.model.user;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull
    private String email;

    @NotNull
    private String name;

    @NotNull
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
