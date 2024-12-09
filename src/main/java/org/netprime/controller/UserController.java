package org.netprime.controller;

import org.netprime.dto.ApiResponse;
import org.netprime.dto.UserRequest;
import org.netprime.dto.UserResponse;
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
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@RequestBody UserRequest userRequest) {
        // User service call
        UserResponse createdUser = userService.createUser(userRequest);
        // Build the api response
        ApiResponse<UserResponse> response = new ApiResponse<>(
                true,
                "User created successfully",
                createdUser);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> updateUser(@PathVariable long id, @RequestBody UserRequest userRequest) {
        // User service call
        UserResponse updatedUser = userService.updateUser(id, userRequest);
        // Build the api response
        ApiResponse<UserResponse> response = new ApiResponse<>(
                true,
                "User updated successfully",
                updatedUser
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserByUsername(@PathVariable String username) {
        // User service call
        UserResponse user = userService.getUserByUsername(username);
        // Build the api response
        ApiResponse<UserResponse> response = new ApiResponse<>(
                true,
                "User found",
                user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> deleteUser(@PathVariable long id) {
        // User service call
        userService.deleteUser(id);
        // Build the api response
        ApiResponse<UserResponse> response = new ApiResponse<>(
          true,
          "User deleted successfully",
                null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
