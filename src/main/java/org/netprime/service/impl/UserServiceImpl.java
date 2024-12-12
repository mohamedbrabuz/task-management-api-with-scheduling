package org.netprime.service.impl;

import org.netprime.dto.UserRequest;
import org.netprime.dto.UserResponse;
import org.netprime.exception.UserNotFoundException;
import org.netprime.model.User;
import org.netprime.repository.UserRepository;
import org.netprime.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setUsername(userRequest.getUsername());
        User savedUser = userRepository.save(user);
        return new UserResponse().toUserResponse(savedUser);
    }

    @Override
    public UserResponse updateUser(long id, UserRequest userRequest) {
        // Find the User by the given ID
        User user = userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User not found with the given id " + id));
        // Update user fields
        user.setName(userRequest.getName());
        user.setUsername(userRequest.getUsername());
        User savedUser = userRepository.save(user);

        return new UserResponse().toUserResponse(savedUser);
    }

    @Override
    public UserResponse getUserByUsername(String username) {
        // Find the User by the given username
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UserNotFoundException("User not found with the given username " + username));
        // Return the user with the given ID
        return new UserResponse().toUserResponse(user);
    }

    @Override
    public void deleteUser(long id) {
        // Find the User by the given ID
        User user = userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User not found with the given id " + id));
        // Delete the user with the given ID
        userRepository.delete(user);
    }
}
