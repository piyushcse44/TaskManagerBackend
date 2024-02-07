package com.taskmanager.taskmanager.model;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tasks")
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

    public Tasks() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public List<InternalStaff> getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(List<InternalStaff> assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Tasks(String subject, String status, Users user, LocalDateTime dueDate, List<InternalStaff> assignedTo) {
        this.subject = subject;
        this.status = status;
        this.user = user;
        this.dueDate = dueDate;
        this.assignedTo = assignedTo;
    }


}
