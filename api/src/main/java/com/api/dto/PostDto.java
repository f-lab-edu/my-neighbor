package com.api.dto;

import com.api.model.group.PostPublicType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class PostDto {

    private Long postId;

    private Long groupId;

    private Long writerId;

    private String writerEmail;

    private String writerName;

    private String contents;

    private int count;

    private PostPublicType publicType;

    private LocalDateTime modifyAt;

    private LocalDateTime createAt;

    @Override
    public String toString() {
        return "PostDto{" +
                "postId=" + postId +
                ", groupId=" + groupId +
                ", writerId=" + writerId +
                ", writerEmail='" + writerEmail + '\'' +
                ", writerName='" + writerName + '\'' +
                ", contents='" + contents + '\'' +
                ", count=" + count +
                ", publicType='" + publicType + '\'' +
                ", modifyAt=" + modifyAt +
                ", createAt=" + createAt +
                '}';
    }
}
