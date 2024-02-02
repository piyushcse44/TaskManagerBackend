package com.taskmanager.taskmanager.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.scheduling.config.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternalStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "internalStaff_sequence")
    @SequenceGenerator(name = "your_entity_seq", sequenceName = "internalStaff_sequence", allocationSize = 1)
    private long id;
    private String emp_num;
    private String name;
    private String email;
    private LocalDateTime created_on;

   @ManyToMany(mappedBy = "assignedTo")
   private List<Tasks> tasks = new ArrayList<Tasks>();




}
