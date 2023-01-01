package com.api.controller.user;

import java.util.StringJoiner;

public class JoinRequest {

    private String principal;

    public String name;

    private String credential;

    private JoinRequest() {
    }

    public JoinRequest(String principal, String name, String credential) {
        this.principal = principal;
        this.name = name;
        this.credential = credential;
    }

    public String getPrincipal() {
        return principal;
    }

    public String getName() {
        return name;
    }

    public String getCredential() {
        return credential;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JoinRequest.class.getSimpleName() + "[", "]")
                .add("principal='" + principal + "'")
                .add("name='" + name + "'")
                .add("credential='" + credential + "'")
                .toString();
    }
}
