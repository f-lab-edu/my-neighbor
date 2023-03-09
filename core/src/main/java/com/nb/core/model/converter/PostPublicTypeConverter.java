package com.nb.core.model.converter;

import com.nb.core.model.group.PostPublicType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class PostPublicTypeConverter implements AttributeConverter<PostPublicType, String> {

    @Override
    public String convertToDatabaseColumn(PostPublicType postPublicType) {
        if(postPublicType == null) return null;

        return postPublicType.getValue();
    }

    @Override
    public PostPublicType convertToEntityAttribute(String s) {
        if (s == null) return null;

        return Stream.of(PostPublicType.values())
                .filter(c -> c.getValue().equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
