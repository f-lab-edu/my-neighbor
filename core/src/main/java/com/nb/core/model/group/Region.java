package com.nb.core.model.group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "regions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer regionId;

    @NotNull(message = "depth1 is mandatory")
    private String depth1;

    private String depth2;

    private String depth3;

    @Override
    public String toString() {
        return "Region{" +
                "regionId=" + regionId +
                ", depth1='" + depth1 + '\'' +
                ", depth2='" + depth2 + '\'' +
                ", depth3='" + depth3 + '\'' +
                '}';
    }
}
