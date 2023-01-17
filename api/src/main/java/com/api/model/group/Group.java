package com.api.model.group;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Getter
@AllArgsConstructor
public class Group {

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

    public Group(Integer categoryId, Long leaderId, String name, String desc, String publicType) {
        this(categoryId, leaderId, name, desc, null, publicType, 20, 0, 0);
    }

    public Group(Integer categoryId, Long leaderId, String name, String desc, String groupImageUrl, String publicType, int maxNum, int cityId, int townId) {
        this(null, categoryId, leaderId, name, desc, groupImageUrl, publicType, maxNum, cityId, townId, null, now());
    }

    @Override
    public String toString() {
        return "Group{" +
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
