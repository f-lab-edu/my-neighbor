package com.api.controller.group;

import com.api.controller.ApiResult;
import com.api.dto.CreatePostRequest;
import com.api.dto.PostDto;
import com.api.service.group.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.api.controller.ApiResult.ERROR;
import static com.api.controller.ApiResult.OK;
import static com.api.controller.group.GroupMapper.toDto;
import static com.api.controller.group.GroupMapper.toEntity;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/post")
public class PostController {

    private final PostService postService;

    // 그룹 내 모든 포스팅 조회
    @GetMapping("/{groupId}")
    public ApiResult<List<PostDto>> getPosts(@PathVariable Long groupId) {
        return OK(
                postService.findAllByGroupId(groupId)
                        .stream()
                        .map(GroupMapper::toDto)
                        .collect(Collectors.toList())
        );
    }

    // 포스팅 작성
    @PostMapping
    public ApiResult<PostDto> createPost(@RequestBody CreatePostRequest request) {
        return OK(
                toDto(
                        postService.save(toEntity(request))
                )
        );
    }

    // 포스팅 수정
    @PatchMapping
    public ApiResult<PostDto> updatePost(@RequestBody PostDto postDto) {
        return OK(
                toDto(
                        postService.updatePost(toEntity(postDto))
                )
        );
    }

    // 포스팅 삭제
    @DeleteMapping("/{postId}")
    public ApiResult<PostDto> deletePost(@PathVariable Long postId) {
        try {
            return OK(
                    toDto(postService.deletePost(postId))
            );
        } catch (Exception e) {
            return ERROR(
                    HttpStatus.NOT_FOUND, e.getMessage()
            );
        }
    }
}
