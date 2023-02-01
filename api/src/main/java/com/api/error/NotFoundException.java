package com.api.error;

import com.api.util.MessageUtils;
import lombok.Getter;

import java.util.Arrays;

@Getter
public class NotFoundException extends RuntimeException {

    private final String messageKey = "error.notfound";

    private final String detailKey = "error.notfound.details";

    private final Object[] params;

    public NotFoundException(Class<?> cls, Object ... values) {
        this.params = new String[]{cls.getSimpleName(), (values != null && values.length > 0) ? String.join(",", Arrays.toString(values)) : ""};
    }

    @Override
    public String getMessage() {
        return MessageUtils.getMessage(detailKey, params);
    }

    @Override
    public String toString() {
        return MessageUtils.getMessage(messageKey);
    }
}
