package com.api.service.group;

import com.api.error.NotFoundException;
import com.api.model.group.Post;
import com.api.repository.group.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final Clock clock;

    @Transactional
    public Post save(Post post) {
        post.updateCreateAt(clock);
        return postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public List<Post> findAllByGroupId(Long groupId) {
        return postRepository.findAllByGroupId(groupId);
    }

    public Optional<Post> findById(Long postId) {
        return postRepository.findById(postId);
    }

    @Transactional(readOnly = true)
    public Optional<Post> findByPostIdAndGroupId(Long postId, Long groupId) {
        return postRepository.findByPostIdAndGroupId(postId, groupId);
    }

    @Transactional(readOnly = true)
    public List<Post> findByWriterId(Long writerId) {
        return postRepository.findByWriterId(writerId);
    }

    @Transactional
    public Post updatePost(Post post) {
        Post target = findByPostIdAndGroupId(post.getPostId(), post.getGroupId()).orElseThrow(() -> new NotFoundException(Post.class, post.getPostId(), post.getGroupId()));
        target.setContents(post.getContents());
        target.setPublicType(post.getPublicType());
        target.updateModifyAt(clock);
        return target;
    }

    @Transactional
    public Post deletePost(Long postId) {
        Post target = findById(postId).orElseThrow(() -> new NotFoundException(Post.class, postId));
        postRepository.delete(target);
        return target;
    }
}
