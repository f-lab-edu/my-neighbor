package com.nb.core.model.group;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Clock;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @NotNull
    private Long groupId;

    @NotNull
    private Long writerId;

    private String writerEmail;

    private String writerName;

    @NotNull
    @Setter
    private String contents;

    private int count;

    @NotNull
    @Setter
    private PostPublicType publicType;

    @Column(insertable = false)
    private LocalDateTime modifyAt;

    @Column(updatable = false)
    private LocalDateTime createAt;

    public void updateModifyAt(Clock clock) {
        this.modifyAt = LocalDateTime.now(clock);
    }

    public void updateCreateAt(Clock clock) {
        this.createAt = LocalDateTime.now(clock);
    }

    @Override
    public String toString() {
        return "Post{" +
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
