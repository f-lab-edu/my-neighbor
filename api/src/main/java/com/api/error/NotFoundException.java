package com.api.error;

import lombok.Getter;
import org.springframework.context.support.MessageSourceAccessor;

import java.util.Arrays;

@Getter
public class NotFoundException extends RuntimeException {

    private final String messageKey = "error.notfound";

    private final String detailKey = "error.notfound.details";

    private final MessageSourceAccessor messageSourceAccessor;

    private final Object[] params;

    public NotFoundException(MessageSourceAccessor messageSourceAccessor, Class<?> cls, Object ... values) {
        this.messageSourceAccessor = messageSourceAccessor;
        this.params = new String[]{cls.getSimpleName(), (values != null && values.length > 0) ? String.join(",", Arrays.toString(values)) : ""};
    }

    @Override
    public String getMessage() {
        return messageSourceAccessor.getMessage(detailKey, params);
    }

    @Override
    public String toString() {
        return messageSourceAccessor.getMessage(messageKey);
    }
}
