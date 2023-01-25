package com.api.dto;

import com.api.model.group.Writer;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreatePostRequest {

    private Long groupId;

    private Writer writer;

    private String contents;

    private String publicType;

    @Override
    public String toString() {
        return "CreatePostRequest{" +
                "groupId=" + groupId +
                ", writer=" + writer +
                ", contents='" + contents + '\'' +
                ", publicType='" + publicType + '\'' +
                '}';
    }
}
