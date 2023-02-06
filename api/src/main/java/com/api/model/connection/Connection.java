package com.api.model.connection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.Clock;
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

    @NotNull(message = "group Id is mandatory")
    private Long groupId;

    @NotNull(message = "user Id is mandatory")
    private Long userId;

    private LocalDateTime createAt;

    public Connection(Long groupId, Long userId) {
        this.groupId = groupId;
        this.userId = userId;
    }

    public void updateCreateAt(Clock clock) {
        this.createAt = LocalDateTime.now(clock);
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
