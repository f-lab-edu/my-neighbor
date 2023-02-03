package com.api.model.group;

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
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @NotNull(message = "depth1 is mandatory")
    private String depth1;

    private String depth2;

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", depth1='" + depth1 + '\'' +
                ", depth2='" + depth2 + '\'' +
                '}';
    }
}
