package com.api.controller.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JoinRequest {

    private String principal;

    public String name;

    private String credentials;

    private JoinRequest() {
    }

    @Override
    public String toString() {
        return "JoinRequest{" +
                "principal='" + principal + '\'' +
                ", name='" + name + '\'' +
                ", credentials='" + credentials + '\'' +
                '}';
    }
}
