package com.api.dto.group;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateGroupRequest {

    private Integer categoryId;

    private Long leaderId;

    private String name;

    private String desc;

    private String groupImageUrl;

    private String publicType;

    private int maxNum;

    private int cityId;

    private int townId;

    @Override
    public String toString() {
        return "GroupUpdateRequest{" +
                "categoryId=" + categoryId +
                ", leaderId=" + leaderId +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", groupImageUrl='" + groupImageUrl + '\'' +
                ", publicType='" + publicType + '\'' +
                ", maxNum=" + maxNum +
                ", cityId=" + cityId +
                ", townId=" + townId +
                '}';
    }
}
