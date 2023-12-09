package com.example.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtask")
    private int idTask;
    @Column(name = "title")
    private String title;
    @Column(name="description")
    private String description;
    @Column(name = "comment")
    private String comment;
    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private Status  status;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "priority")
    private Priority priority ;
}
