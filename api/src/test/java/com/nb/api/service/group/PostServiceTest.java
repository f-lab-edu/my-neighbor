package com.nb.api.service.group;

import com.nb.core.model.group.Post;
import com.nb.core.model.group.PostPublicType;
import com.nb.core.repository.group.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
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
                .writerId(1L)
                .writerEmail("testeamil@gmail.com")
                .writerName("test email")
                .contents("test content")
                .publicType(PostPublicType.PUBLIC)
                .build();

        post = Post.builder()
                .postId(1L)
                .groupId(1L)
                .writerId(1L)
                .writerEmail("testeamil@gmail.com")
                .writerName("test email")
                .contents("test content")
                .publicType(PostPublicType.PUBLIC)
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
        when(postRepository.findByPostIdAndGroupId(any(), any())).thenReturn(Optional.ofNullable(post));

        Post res = postService.updatePost(post);

        assertThat(res.getModifyAt()).isEqualTo(LocalDateTime.now(clock));
    }
}
