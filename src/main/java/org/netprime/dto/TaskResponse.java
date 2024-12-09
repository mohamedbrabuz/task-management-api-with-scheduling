package org.netprime.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.netprime.model.Task;

@Data
@NoArgsConstructor
public class TaskResponse {

    private String title;
    private String description;
    private String duaDate;
    private boolean isCompleted;

    public TaskResponse toTaskResponse(Task task) {
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setTitle(taskResponse.getTitle());
        taskResponse.setDescription(task.getDescription());
        taskResponse.setDuaDate(taskResponse.getDuaDate());
        taskResponse.setCompleted(taskResponse.isCompleted());
        return taskResponse;
    }
}
