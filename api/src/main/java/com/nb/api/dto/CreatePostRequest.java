package com.nb.api.dto;

import com.nb.core.model.group.PostPublicType;
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

    private PostPublicType publicType;

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
