package org.netprime.service.impl;

import org.netprime.dto.TaskRequest;
import org.netprime.dto.TaskResponse;
import org.netprime.exception.TaskNotFoundException;
import org.netprime.exception.UserNotFoundException;
import org.netprime.model.Task;
import org.netprime.model.User;
import org.netprime.repository.TaskRepository;
import org.netprime.repository.UserRepository;
import org.netprime.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<TaskResponse> getAllTasks(long userId) {
        // Find the User by the given ID
        User user = userRepository.findById(userId).orElseThrow(() ->
                new UserNotFoundException("User not found with the given id" + userId));

        // Return all tasks related to a specific user
        return user.getTasks().stream().map(task ->
                new TaskResponse().toTaskResponse(task))
                .toList();
    }

    @Override
    public TaskResponse getTaskById(long userId, long taskId) {
        // Find the User by the given ID
        User user = userRepository.findById(userId).orElseThrow(() ->
                new UserNotFoundException("User not found with the given id" + userId));
        Task response = user.getTasks().stream().filter(task ->
                task.getId() == taskId)
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException("Task not found with the given id" + taskId));
        return new TaskResponse().toTaskResponse(response);
    }

    @Override
    public TaskResponse createTask(long userId, TaskRequest taskRequest) {
        System.out.println(taskRequest);
        // Find the User by the given ID
        User user = userRepository.findById(userId).orElseThrow(() ->
                new UserNotFoundException("User not found with the given id" + userId));

        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setDueDate(taskRequest.getDueDate());
        task.setCompleted(taskRequest.isCompleted());
        task.setUser(user);
        Task savedTask = taskRepository.save(task);

        return new TaskResponse().toTaskResponse(savedTask);
    }

    @Override
    public TaskResponse updateTask(long userId, long taskId, TaskRequest taskRequest) {
        // Find the User by the given ID
        User user = userRepository.findById(userId).orElseThrow(() ->
                new UserNotFoundException("User not found with the given id" + userId));
        // Filter the task by the given ID
        Task filteredTask = user.getTasks().stream().filter(task ->
                task.getId() == taskId)
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException("Task not found with the given id" + taskId));
        // Update an existing task
        filteredTask.setTitle(taskRequest.getTitle());
        filteredTask.setDescription(taskRequest.getDescription());
        filteredTask.setDueDate(taskRequest.getDueDate());
        filteredTask.setCompleted(taskRequest.isCompleted());
        Task savedTask = taskRepository.save(filteredTask);

        return new TaskResponse().toTaskResponse(savedTask);
    }

    @Override
    public void deleteTask(long userId, long taskId) {
        // Find the User by the given ID
        User user = userRepository.findById(userId).orElseThrow(() ->
                new UserNotFoundException("User not found with the given id" + userId));
        // Filter the task by the given ID
        Task filteredTask = user.getTasks().stream().filter(task ->
                        task.getId() == taskId)
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException("Task not found with the given id" + taskId));

        taskRepository.delete(filteredTask);
    }
}
