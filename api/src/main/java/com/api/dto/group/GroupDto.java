package com.api.dto.group;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class GroupDto {

    private Long groupId;

    private Integer categoryId;

    private Long leaderId;

    private String name;

    private String desc;

    private String groupImageUrl;

    private String publicType;

    private int maxNum;

    private int cityId;

    private int townId;

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
                ", cityId=" + cityId +
                ", townId=" + townId +
                ", modifyAt=" + modifyAt +
                ", createAt=" + createAt +
                '}';
    }
}
