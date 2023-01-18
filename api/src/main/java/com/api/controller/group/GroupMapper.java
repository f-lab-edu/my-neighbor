package com.api.controller.group;

import com.api.dto.group.GroupDto;
import com.api.model.group.Group;

import java.time.LocalDateTime;

public class GroupMapper<T> {

    public static GroupDto toDto(Group group) {
        Long groupId = group.getGroupId();
        Integer categoryId = group.getCategoryId();
        Long leaderId = group.getLeaderId();
        String name = group.getName();
        String desc = group.getDesc();
        String groupImageUrl = group.getGroupImageUrl();
        String publicType = group.getPublicType();
        int maxNum = group.getMaxNum();
        int cityId = group.getCityId();
        int townId = group.getTownId();
        LocalDateTime modifyAt = group.getModifyAt();
        LocalDateTime createAt = group.getCreateAt();

        return new GroupDto(groupId, categoryId, leaderId, name, desc, groupImageUrl, publicType, maxNum, cityId, townId, modifyAt, createAt);
    }

    public static Group toEntity(GroupDto groupDto) {
        Long groupId = groupDto.getGroupId();
        Integer categoryId = groupDto.getCategoryId();
        Long leaderId = groupDto.getLeaderId();
        String name = groupDto.getName();
        String desc = groupDto.getDesc();
        String groupImageUrl = groupDto.getGroupImageUrl();
        String publicType = groupDto.getPublicType();
        int maxNum = groupDto.getMaxNum();
        int cityId = groupDto.getCityId();
        int townId = groupDto.getTownId();
        LocalDateTime modifyAt = groupDto.getModifyAt();
        LocalDateTime createAt = groupDto.getCreateAt();

        return new Group(groupId, categoryId, leaderId, name, desc, groupImageUrl, publicType, maxNum, cityId, townId, modifyAt, createAt);
    }
}
