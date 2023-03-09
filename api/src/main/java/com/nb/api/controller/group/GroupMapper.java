package com.nb.api.controller.group;

import com.nb.api.dto.CreateGroupRequest;
import com.nb.api.dto.CreatePostRequest;
import com.nb.api.dto.GroupDto;
import com.nb.api.dto.PostDto;
import com.nb.api.dto.UpdateGroupRequest;
import com.nb.api.dto.UpdatePostRequest;
import com.nb.core.model.group.Group;
import com.nb.core.model.group.Post;

public class GroupMapper {

    /** group mapping **/
    public static GroupDto toDto(Group group) {
        return new GroupDto(group.getGroupId(), group.getCategoryId(), group.getLeaderId(),
                group.getName(), group.getDesc(), group.getGroupImageUrl(),
                group.getPublicType(), group.getMaxNum(), group.getRegionId(),
                group.getModifyAt(), group.getCreateAt());
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
                .regionId(groupDto.getRegionId())
                .modifyAt(groupDto.getModifyAt())
                .createAt(groupDto.getCreateAt())
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
                .regionId(request.getCityId())
                .build();
    }

    public static Group toEntity(UpdateGroupRequest request) {
        return Group.builder()
                .groupId(request.getGroupId())
                .categoryId(request.getCategoryId())
                .leaderId(request.getLeaderId())
                .name(request.getName())
                .desc(request.getDesc())
                .groupImageUrl(request.getGroupImageUrl())
                .publicType(request.getPublicType())
                .maxNum(request.getMaxNum())
                .regionId(request.getCityId())
                .build();
    }


    /** group posting mapping **/
    public static PostDto toDto(Post post) {
        return new PostDto(post.getPostId(), post.getGroupId(), post.getWriterId(),
                post.getWriterEmail(), post.getWriterName(), post.getContents(),
                post.getCount(), post.getPublicType(), post.getModifyAt(),
                post.getCreateAt());
    }

    public static Post toEntity(PostDto postDto) {
        return Post.builder()
                .postId(postDto.getPostId())
                .groupId(postDto.getGroupId())
                .writerId(postDto.getWriterId())
                .writerEmail(postDto.getWriterEmail())
                .writerName(postDto.getWriterName())
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
                .writerId(request.getWriterId())
                .writerEmail(request.getWriterEmail())
                .writerName(request.getWriterName())
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
