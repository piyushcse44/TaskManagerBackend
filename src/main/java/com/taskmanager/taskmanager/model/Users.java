package com.taskmanager.taskmanager.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table
public class Users {

    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    @SequenceGenerator(name = "your_entity_seq", sequenceName = "users_sequence", allocationSize = 1)
    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdOn;



    public String getName() {
        return name;
    }

    public Users() {
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

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public Users(String name, String email) {

        this.name = name;
        this.email = email;

    }
}
