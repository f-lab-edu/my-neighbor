package com.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdatePostRequest {

    private Long postId;

    private Long groupId;

    private String contents;

    private String publicType;

    @Override
    public String toString() {
        return "UpdatePostRequest{" +
                "postId=" + postId +
                ", groupId=" + groupId +
                ", contents='" + contents + '\'' +
                ", publicType='" + publicType + '\'' +
                '}';
    }
}
