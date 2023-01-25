package com.api.dto;

import com.api.model.group.Writer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class PostDto {

    private Long postId;

    private Long groupId;

    private Writer writer;

    private String contents;

    private int count;

    private String publicType;

    private LocalDateTime modifyAt;

    private LocalDateTime createAt;

    @Override
    public String toString() {
        return "PostDto{" +
                "postId=" + postId +
                ", groupId=" + groupId +
                ", writer=" + writer +
                ", contents='" + contents + '\'' +
                ", count=" + count +
                ", publicType='" + publicType + '\'' +
                ", modifyAt=" + modifyAt +
                ", createAt=" + createAt +
                '}';
    }
}
