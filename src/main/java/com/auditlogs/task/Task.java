package com.auditlogs.task;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Task implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;
    @Column(name = "is_completed")
    private boolean isCompleted=false;

    public Task(String name, String description, boolean isCompleted) {
        this.name = name;
        this.description = description;
        this.isCompleted = isCompleted;
    }
}
