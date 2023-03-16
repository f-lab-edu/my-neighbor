package com.nb.api.serializers;

import com.nb.api.dto.ConnectionDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

public class ConnectionDtoDeSerializer implements Deserializer {
    @Override
    public ConnectionDto deserialize(String arg0, byte[] arg1) {
        ObjectMapper mapper = new ObjectMapper();
        ConnectionDto dto = null;
        try {
            dto = mapper.readValue(arg1, ConnectionDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }
}
