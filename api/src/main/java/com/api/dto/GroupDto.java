package com.api.dto;

import com.api.model.group.GroupPublicType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class GroupDto {

    private Long groupId;

    private Integer categoryId;

    private Long leaderId;

    private String name;

    private String desc;

    private String groupImageUrl;

    private GroupPublicType publicType;

    private int maxNum;

    private int regionId;

    private LocalDateTime modifyAt;

    private LocalDateTime createAt;

    @Override
    public String toString() {
        return "GroupDto{" +
                "groupId=" + groupId +
                ", categoryId=" + categoryId +
                ", leaderId=" + leaderId +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", groupImageUrl='" + groupImageUrl + '\'' +
                ", publicType=" + publicType +
                ", maxNum=" + maxNum +
                ", cityId=" + regionId +
                ", modifyAt=" + modifyAt +
                ", createAt=" + createAt +
                '}';
    }
}
