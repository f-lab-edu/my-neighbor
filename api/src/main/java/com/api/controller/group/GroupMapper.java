package com.api.controller.group;

import com.api.dto.group.GroupDto;
import com.api.model.group.Group;

import java.time.LocalDateTime;

public class GroupMapper {
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
}
