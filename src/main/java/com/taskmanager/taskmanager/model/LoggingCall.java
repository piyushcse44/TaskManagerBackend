package com.taskmanager.taskmanager.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDateTime;

@Entity
@Table

public class LoggingCall {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_sequence")
    @SequenceGenerator(name = "task_sequence", sequenceName = "task_sequence", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "createdBy")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Users user;
    private String customerName;
    private String contactDetails;
    private LocalDateTime createdOn;
    @Column(length = 1000)
    private String description;


    public LoggingCall() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LoggingCall(Users user, String customerName, String contactDetails, String description) {
        this.user = user;
        this.customerName = customerName;
        this.contactDetails = contactDetails;
        this.description = description;
    }

    public LoggingCall(String customerName, String contactDetails, LocalDateTime createdOn, String description) {
        this.customerName = customerName;
        this.contactDetails = contactDetails;
        this.createdOn = createdOn;
        this.description = description;
    }
}
