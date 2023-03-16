package com.nb.api.controller.group;

import com.nb.api.controller.ApiResult;
import com.nb.api.dto.CreatePostRequest;
import com.nb.api.dto.PostDto;
import com.nb.api.dto.UpdatePostRequest;
import com.nb.api.service.group.PostService;
import lombok.RequiredArgsConstructor;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("api/post")
public class PostController {

    private final PostService postService;

    // 그룹 내 모든 포스트 조회
    @GetMapping("/{groupId}")
    public ApiResult<List<PostDto>> postList(@PathVariable Long groupId) {
        return ApiResult.Ok(
            postService.findAllByGroupId(groupId)
                    .stream()
                    .map(GroupMapper::toDto)
                    .collect(Collectors.toList())
        );
    }

    // 포스트 작성
    @PostMapping
    public ApiResult<PostDto> postSave(@RequestBody CreatePostRequest request) {
        return ApiResult.Ok(
            GroupMapper.toDto(
                postService.save(GroupMapper.toEntity(request))
            )
        );
    }

    // 포스트 수정
    @PatchMapping
    public ApiResult<PostDto> postModify(@RequestBody UpdatePostRequest request) {
        return ApiResult.Ok(
            GroupMapper.toDto(
                postService.updatePost(GroupMapper.toEntity(request))
            )
        );
    }

    // 포스트 삭제
    @DeleteMapping("/{postId}")
    public ApiResult<PostDto> postRemove(@PathVariable Long postId) {
        return ApiResult.Ok(
                GroupMapper.toDto(postService.deletePost(postId))
        );
    }
}
