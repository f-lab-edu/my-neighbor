package com.api.service.group;

import com.api.model.group.Post;
import com.api.model.group.Writer;
import com.api.repository.group.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PostServiceTest {

    PostService postService;

    @Mock
    PostRepository postRepository;

    @Mock
    private Clock clock;

    private Post noIdPost;

    private Post post;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        String fixedTime = "2023-01-22T10:05:23.653Z";
        when(clock.instant()).thenReturn(Instant.parse(fixedTime));
        when(clock.getZone()).thenReturn(ZoneId.systemDefault());

        postService = new PostService(postRepository, clock);

        noIdPost = Post.builder()
                .groupId(1L)
                .writer(new Writer(1L, "test writer", "test email"))
                .contents("test content")
                .publicType("PRIVATE_POST")
                .build();

        post = Post.builder()
                .postId(5L)
                .groupId(1L)
                .writer(new Writer(1L, "test writer", "test email"))
                .contents("test content")
                .publicType("PRIVATE_POST")
                .build();
    }

    @Test
    void 포스트를_생성한다() {
        when(postRepository.save(any(Post.class))).thenReturn(post);

        postService.save(noIdPost);

        assertThat(noIdPost.getCreateAt()).isEqualTo(LocalDateTime.now(clock));
    }

    @Test
    void 포스트를_수정한다() {
        when(postRepository.save(any(Post.class))).thenReturn(post);

        postService.updatePost(post);

        Assertions.assertThat(post.getModifyAt()).isEqualTo(LocalDateTime.now(clock));

    }
}