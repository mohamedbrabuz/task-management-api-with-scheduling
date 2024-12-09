package org.netprime.controller;

import org.netprime.dto.ApiResponse;
import org.netprime.dto.TaskRequest;
import org.netprime.dto.TaskResponse;
import org.netprime.service.impl.TaskServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskServiceImpl taskService;

    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse> getTasks(@PathVariable long userId) {
        // Task service call
        List<TaskResponse> tasks = taskService.getAllTasks(userId);
        // Build the api response
        ApiResponse response = ApiResponse.builder()
                .success(true)
                .message("Request successful")
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/{taskId}")
    public ResponseEntity<ApiResponse> getTaskById(@PathVariable long userId, @PathVariable long taskId) {
        TaskResponse task = taskService.getTaskById(userId, taskId);
        // Build the api response
        ApiResponse response = ApiResponse.builder()
                .success(true)
                .message("Request successful")
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<ApiResponse> createTask(@PathVariable long userId, @RequestBody TaskRequest taskRequest) {
        // Task service call
        TaskResponse createdTask = taskService.createTask(userId, taskRequest);
        // Build the api response
        ApiResponse response = ApiResponse.builder()
                .success(true)
                .message("Task created successfully")
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/user/{userId}/{taskId}")
    public ResponseEntity<ApiResponse> updateTask(@PathVariable long userId, @PathVariable long taskId, @RequestBody TaskRequest taskRequest) {
        TaskResponse updatedTask = taskService.updateTask(userId, taskId, taskRequest);
        // Build the api response
        ApiResponse response = ApiResponse.builder()
                .success(true)
                .message("Task updated successfully")
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/user/{userId}/{taskId}")
    public ResponseEntity<ApiResponse> deleteTask(@PathVariable long userId, @PathVariable long taskId) {
        taskService.deleteTask(userId, taskId);
        // Build the api response
        ApiResponse response = ApiResponse.builder()
                .success(true)
                .message("Task deleted successfully")
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
