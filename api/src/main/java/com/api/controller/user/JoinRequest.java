package com.api.controller.user;

import java.util.StringJoiner;

public class JoinRequest {

    private String principal;

    public String name;

    private String credentials;

    private JoinRequest() {
    }

    public JoinRequest(String principal, String name, String credentials) {
        this.principal = principal;
        this.name = name;
        this.credentials = credentials;
    }

    public String getPrincipal() {
        return principal;
    }

    public String getName() {
        return name;
    }

    public String getCredentials() {
        return credentials;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JoinRequest.class.getSimpleName() + "[", "]")
                .add("principal='" + principal + "'")
                .add("name='" + name + "'")
                .add("credentials='" + credentials + "'")
                .toString();
    }
}
