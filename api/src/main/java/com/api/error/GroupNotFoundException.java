package com.api.error;

public class GroupNotFoundException extends RuntimeException {

    public GroupNotFoundException() {
        super();
    }

    public GroupNotFoundException(String s) {
        super(s);
    }
}
