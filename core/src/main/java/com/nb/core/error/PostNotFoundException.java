package com.nb.core.error;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException() {
        super();
    }

    public PostNotFoundException(String s) {
        super(s);
    }
}
