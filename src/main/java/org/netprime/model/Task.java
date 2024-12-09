package org.netprime.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "tasks")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date dueDate;

    @Column(nullable = false)
    private boolean isCompleted;

    @Column(nullable = false)
    @CreationTimestamp
    private Date created_at;

    @Column(nullable = false)
    @UpdateTimestamp
    private Date updated_at;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
