package org.netprime.service;

import org.netprime.dto.TaskRequest;
import org.netprime.dto.TaskResponse;
import org.netprime.model.Task;

import java.util.List;

public interface TaskService {

    List<TaskResponse> getAllTasks(long userId);
    TaskResponse getTaskById(long userId, long taskId);
    TaskResponse createTask(long userId, TaskRequest taskRequest);
    TaskResponse updateTask(long userId, long taskId, TaskRequest taskRequest);
    void deleteTask(long userId, long taskId);

    void sendReminders(Task task);
    void scheduleTaskChecks();
}
