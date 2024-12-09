package org.netprime.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TaskRequest {

    private String title;
    private String description;
    private Date dueDate;
    private boolean isCompleted;
}