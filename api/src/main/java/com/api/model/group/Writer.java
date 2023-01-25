package com.api.model.group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Writer {

    private Long userId;

    private String email;

    private String name;

    @Override
    public String toString() {
        return "Writer{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
