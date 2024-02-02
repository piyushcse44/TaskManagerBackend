package com.taskmanager.taskmanager.model;

import com.taskmanager.taskmanager.model.InternalStaff;
import com.taskmanager.taskmanager.model.Users;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_sequence")
    @SequenceGenerator(name = "task_sequence", sequenceName = "task_sequence", allocationSize = 1)
    private Long id;

    private String subject;
    private String status;

    @ManyToOne
    @JoinColumn(name = "createdBy")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Users user;

    private LocalDateTime createdOn;
    private LocalDateTime dueDate;

    @ManyToMany
    private List<InternalStaff> assignedTo = new ArrayList<>();
}
