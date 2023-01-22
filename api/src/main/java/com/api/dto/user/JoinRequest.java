package com.api.dto.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JoinRequest {

    private String principal;

    public String name;

    private String credentials;

    @Override
    public String toString() {
        return "JoinRequest{" +
                "principal='" + principal + '\'' +
                ", name='" + name + '\'' +
                ", credentials='" + credentials + '\'' +
                '}';
    }
}
