package com.api.controller.user;

import java.util.StringJoiner;

public class JoinRequest {

    private String principal;

    public String name;

    private String credential;

    public JoinRequest() {
    }

    public JoinRequest(String principal, String name, String credential) {
        this.principal = principal;
        this.name = name;
        this.credential = credential;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
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
