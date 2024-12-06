package org.netprime.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;
    private Date dueDate;
    private boolean isCompleted;

    @CreatedDate
    private Date created_at;
    @LastModifiedDate
    private Date updated_at;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
