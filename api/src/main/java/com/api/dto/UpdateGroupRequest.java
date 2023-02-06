package com.api.dto;

import com.api.model.group.GroupPublicType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateGroupRequest {

    private Long groupId;

    private Integer categoryId;

    private Long leaderId;

    private String name;

    private String desc;

    private String groupImageUrl;

    private GroupPublicType publicType;

    private int maxNum;

    private int cityId;

    private int townId;

    @Override
    public String toString() {
        return "UpdateGroupRequest{" +
                "groupId=" + groupId +
                ", categoryId=" + categoryId +
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
