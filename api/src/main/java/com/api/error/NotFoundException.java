package com.api.error;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class NotFoundException extends RuntimeException {

    private final String className;

    private final Object[] params;

    public NotFoundException(Class<?> cls, Object ... values) {
        this.className = cls.getSimpleName();
        this.params = new String[]{(values != null && values.length > 0) ? String.join(",", Arrays.toString(values)) : ""};
    }

    @Override
    public String getMessage() {
        return className + " not found with query values " + params[0];
    }
}
