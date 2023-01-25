package com.api.repository.group;

import com.api.model.group.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post save(Post post);

    List<Post> findAllByGroupId(Long groupId);

    Optional<Post> findById(Long postId);

    List<Post> findByWriterUserId(Long userId);

    void delete(Post post);
}
