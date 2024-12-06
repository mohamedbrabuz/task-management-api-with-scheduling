package org.netprime.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String name;

    @CreatedDate
    private Date created_at;
    @LastModifiedDate
    private Date updated_at;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;
}
