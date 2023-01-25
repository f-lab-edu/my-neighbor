package com.api.controller.group;

import com.api.dto.CreateGroupRequest;
import com.api.dto.CreatePostRequest;
import com.api.dto.GroupDto;
import com.api.dto.PostDto;
import com.api.model.group.Group;
import com.api.model.group.Post;

public class GroupMapper {

    /** group mapping **/
    public static GroupDto toDto(Group group) {
        return new GroupDto(group.getGroupId(), group.getCategoryId(), group.getLeaderId(),
                group.getName(), group.getDesc(), group.getGroupImageUrl(),
                group.getPublicType(), group.getMaxNum(), group.getCityId(),
                group.getTownId(), group.getModifyAt(), group.getCreateAt());
    }

    public static Group toEntity(GroupDto groupDto) {
        return new Group(groupDto.getGroupId(), groupDto.getCategoryId(), groupDto.getLeaderId(),
                groupDto.getName(), groupDto.getDesc(), groupDto.getGroupImageUrl(),
                groupDto.getPublicType(), groupDto.getMaxNum(), groupDto.getCityId(),
                groupDto.getTownId(), groupDto.getModifyAt(), groupDto.getCreateAt());
    }

    public static Group toEntity(CreateGroupRequest request) {
        return new Group(request.getCategoryId(), request.getLeaderId(),
                request.getName(), request.getDesc(), request.getGroupImageUrl(),
                request.getPublicType(), request.getMaxNum(), request.getCityId(),
                request.getTownId());
    }

    /** group posting mapping **/
    public static PostDto toDto(Post post) {
        return new PostDto(post.getPostId(), post.getGroupId(), post.getWriter(),
                post.getContents(), post.getCount(), post.getPublicType(),
                post.getModifyAt(), post.getCreateAt());
    }

    public static Post toEntity(PostDto postDto) {
        return Post.builder()
                .postId(postDto.getPostId())
                .groupId(postDto.getGroupId())
                .writer(postDto.getWriter())
                .contents(postDto.getContents())
                .count(postDto.getCount())
                .publicType(postDto.getPublicType())
                .modifyAt(postDto.getModifyAt())
                .createAt(postDto.getCreateAt())
                .build();
    }

    public static Post toEntity(CreatePostRequest request) {
        return Post.builder()
                .groupId(request.getGroupId())
                .writer(request.getWriter())
                .contents(request.getContents())
                .publicType(request.getPublicType())
                .build();
    }
}
