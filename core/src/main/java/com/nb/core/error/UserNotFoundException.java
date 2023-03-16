package com.nb.core.error;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String s) {
        super(s);
    }
}
