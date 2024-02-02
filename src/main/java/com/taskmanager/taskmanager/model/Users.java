package com.taskmanager.taskmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    @SequenceGenerator(name = "your_entity_seq", sequenceName = "users_sequence", allocationSize = 1)
    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdOn;


}
