package com.api.dto.group;

import com.api.model.group.Group;
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

    // todo mapper 로 변경
    public Group newGroup(Integer categoryId, Long leaderId, String name, String desc, String groupImageUrl, String publicType, int maxNum, int cityId, int townId) {
        return new Group(categoryId, leaderId, name, desc, groupImageUrl, publicType, maxNum, cityId, townId);
    }

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
