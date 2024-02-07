package com.taskmanager.taskmanager.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class InternalStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "internalStaff_sequence")
    @SequenceGenerator(name = "your_entity_seq", sequenceName = "internalStaff_sequence", allocationSize = 1)
    private long id;
    private String emp_num;
    private String name;
    private String email;

    private LocalDateTime created_on;
    public InternalStaff() {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmp_num() {
        return emp_num;
    }

    public void setEmp_num(String emp_num) {
        this.emp_num = emp_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreated_on() {
        return created_on;
    }

    public void setCreated_on(LocalDateTime created_on) {
        this.created_on = created_on;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

    public InternalStaff(String emp_num, String name, String email) {
        this.emp_num = emp_num;
        this.name = name;
        this.email = email;
    }

    public InternalStaff(String emp_num, String name, String email, List<Tasks> tasks) {
        this.emp_num = emp_num;
        this.name = name;
        this.email = email;
        this.tasks = tasks;
    }

    @ManyToMany(mappedBy = "assignedTo")
   private List<Tasks> tasks = new ArrayList<Tasks>();




}
