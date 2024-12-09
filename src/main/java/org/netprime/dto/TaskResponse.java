package org.netprime.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.netprime.model.Task;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TaskResponse {

    private String title;
    private String description;
    private LocalDateTime dueDate;
    private boolean isCompleted;

    public TaskResponse toTaskResponse(Task task) {
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setTitle(task.getTitle());
        taskResponse.setDescription(task.getDescription());
        taskResponse.setDueDate(task.getDueDate());
        taskResponse.setCompleted(task.isCompleted());
        return taskResponse;
    }
}
