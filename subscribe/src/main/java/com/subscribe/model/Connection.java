package com.subscribe.model;

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
@Table(name = "connections")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long connectionId;

    private Long groupId;

    private Long userId;

    private LocalDateTime createAt;

    public Connection(Long groupId, Long userId) {
        this.groupId = groupId;
        this.userId = userId;
    }

    public void updateCreateAt(LocalDateTime now) {
        this.createAt = now;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "connectionId=" + connectionId +
                ", groupId=" + groupId +
                ", userId=" + userId +
                ", createAt=" + createAt +
                '}';
    }
}
