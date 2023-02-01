package com.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreatePostRequest {

    private Long groupId;

    private Long writerId;

    private String writerEmail;

    private String writerName;

    private String contents;

    private String publicType;

    @Override
    public String toString() {
        return "CreatePostRequest{" +
                "groupId=" + groupId +
                ", writerId=" + writerId +
                ", writerEmail='" + writerEmail + '\'' +
                ", writerName='" + writerName + '\'' +
                ", contents='" + contents + '\'' +
                ", publicType='" + publicType + '\'' +
                '}';
    }
}
