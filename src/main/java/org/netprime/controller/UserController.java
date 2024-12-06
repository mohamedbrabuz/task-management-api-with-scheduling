package org.netprime.controller;

import org.netprime.dto.ApiResponse;
import org.netprime.dto.UserRequest;
import org.netprime.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createUser(@RequestBody UserRequest userRequest) {
        // User service call
        userService.createUser(userRequest);
        // Build the api response
        ApiResponse response = ApiResponse.builder()
                .success(true)
                .message("User created successfully")
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable long id, @RequestBody UserRequest userRequest) {
        // User service call
        userService.updateUser(id, userRequest);
        // Build the api response
        ApiResponse response = ApiResponse.builder()
                .success(true)
                .message("User updated successfully")
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<ApiResponse> getUserByUsername(@PathVariable String username) {
        // User service call
        userService.getUserByUsername(username);
        // Build the api response
        ApiResponse response = ApiResponse.builder()
                .success(true)
                .message("User found")
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable long id) {
        // User service call
        userService.deleteUser(id);
        // Build the api response
        ApiResponse response = ApiResponse.builder()
                .success(true)
                .message("User deleted successfully")
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
