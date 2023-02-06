package com.api.model.group;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.Clock;
import java.time.LocalDateTime;

@Entity
@Table(name = "groups")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @NotNull(message = "Category Id is mandatory")
    @Setter
    private Integer categoryId;

    @NotNull(message = "Leader Id is mandatory")
    @Setter
    private Long leaderId;

    @NotNull(message = "Name is mandatory")
    @Setter
    private String name;

    @Setter
    private String desc;

    @Setter
    private String groupImageUrl;

    @NotNull(message = "Public Type is mandatory")
    private GroupPublicType publicType;

    @Setter
    private int maxNum;

    @Setter
    private int cityId;

    @Setter
    private int townId;

    private LocalDateTime modifyAt;

    private LocalDateTime createAt;

    public void updateModifyAt(Clock clock) {
        this.modifyAt = LocalDateTime.now(clock);
    }

    public void updateCreateAt(Clock clock) {
        this.createAt = LocalDateTime.now(clock);
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
