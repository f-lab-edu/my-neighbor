package com.api.model.group;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class Group {


    private Long groupId;

    private int categoryId;

    private int cityId;

    private int townId;

    private String name;

    private String desc;

    private String profileImageUrl;

    private int maxNum;

    private String title;

    private String contents;

    private String masterId;

    private String contentsImageUrl;

    private LocalDateTime createAt;

    private LocalDateTime modifyAt;

    private LocalDateTime writeAt;

    public Group(Long groupId, int categoryId, int cityId, int townId, String name, String desc, String profileImageUrl, String masterId, int maxNum, LocalDateTime createAt){
        // todo validation

        this.groupId = groupId;
        this.categoryId = categoryId;
        this.cityId = cityId;
        this.townId = townId;
        this.name = name;
        this.desc = desc;
        this.masterId = masterId;
        this.profileImageUrl = profileImageUrl;
        this.maxNum = maxNum;
        this.createAt = createAt;
    }

    public  Contents(Long groupId, int categoryId, int cityId, int townId, int maxNum, String title, String contents, String profileImageUrl, String masterId, LocalDateTime writeAt){
        // todo validation

        this.groupId = groupId;
        this.categoryId = categoryId;
        this.cityId = cityId;
        this.townId = townId;
        this.maxNum = maxNum;
        this.title = title;
        this.contents = contents;
        this.profileImageUrl = profileImageUrl;
        this.masterId = masterId;
        this.writeAt = writeAt;
    }

    public Long getGroupId() { return groupId; }

    public int getCategoryId() { return categoryId; }

    public int getCityId() { return  cityId; }

    public int getTownId() { return  townId; }

    public String getName() { return name; }

    public String getDesc() { return  desc; }

    public String getProfileImageUrl() { return  profileImageUrl; }

    public int getMaxNum() { return maxNum; }

    public String getTitle() { return title; }

    public String getContents() { return contents; }

    public String getMasterId() { return masterId; }

    public String getContentsImageUrl() { return contentsImageUrl; }

    public LocalDateTime getCreateAt() { return createAt; }

    public LocalDateTime getModifyAt() { return modifyAt; }

    public LocalDateTime getWriteAt() { return writeAt; }

   //@Override

}
