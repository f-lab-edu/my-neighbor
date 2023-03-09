package com.nb.core.model.converter;

import com.nb.core.model.group.GroupPublicType;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Slf4j
@Converter(autoApply = true)
public class GroupPublicTypeConverter implements AttributeConverter<GroupPublicType, String> {

    @Override
    public String convertToDatabaseColumn(GroupPublicType groupPublicType) {
        if (groupPublicType == null) return null;

        return groupPublicType.getValue();
    }

    @Override
    public GroupPublicType convertToEntityAttribute(String s) {
        if (s == null) return null;

        return Stream.of(GroupPublicType.values())
                .filter(c -> c.getValue().equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
