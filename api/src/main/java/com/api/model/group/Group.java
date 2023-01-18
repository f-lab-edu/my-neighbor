package com.api.model.group;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "groups")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @NotNull
    private Integer categoryId;

    @NotNull
    private Long leaderId;

    @NotNull
    private String name;

    private String desc;

    private String groupImageUrl;

    @NotNull
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
        this(null, categoryId, leaderId, name, desc, groupImageUrl, publicType, maxNum, cityId, townId, null, null);
    }

    public void updateModifyAt() {
        this.modifyAt = LocalDateTime.now();
    }

    public void updateCreateAt() {
        this.createAt = LocalDateTime.now();
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
