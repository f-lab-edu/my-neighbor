package com.api.controller.group;

import com.api.dto.CreateGroupRequest;
import com.api.dto.CreatePostRequest;
import com.api.dto.GroupDto;
import com.api.dto.PostDto;
import com.api.dto.UpdatePostRequest;
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
        return Group.builder()
                .groupId(groupDto.getGroupId())
                .categoryId(groupDto.getCategoryId())
                .leaderId(groupDto.getLeaderId())
                .name(groupDto.getName())
                .desc(groupDto.getDesc())
                .groupImageUrl(groupDto.getGroupImageUrl())
                .publicType(groupDto.getPublicType())
                .maxNum(groupDto.getMaxNum())
                .cityId(groupDto.getCityId())
                .townId(groupDto.getTownId())
                .build();
    }

    public static Group toEntity(CreateGroupRequest request) {
        return Group.builder()
                .categoryId(request.getCategoryId())
                .leaderId(request.getLeaderId())
                .name(request.getName())
                .desc(request.getDesc())
                .groupImageUrl(request.getGroupImageUrl())
                .publicType(request.getPublicType())
                .maxNum(request.getMaxNum())
                .cityId(request.getCityId())
                .townId(request.getTownId())
                .build();
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

    public static Post toEntity(UpdatePostRequest request) {
        return Post.builder()
                .postId(request.getPostId())
                .groupId(request.getGroupId())
                .contents(request.getContents())
                .publicType(request.getPublicType())
                .build();
    }
}
