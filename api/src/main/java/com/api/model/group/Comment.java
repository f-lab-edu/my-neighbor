package com.api.model.group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private Long postId;

    @Embedded
    private Writer writer;

    private String contents;

    private LocalDateTime modifyAt;

    private LocalDateTime createAt;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", writer=" + writer +
                ", contents='" + contents + '\'' +
                ", modifyAt=" + modifyAt +
                ", createAt=" + createAt +
                '}';
    }
}
