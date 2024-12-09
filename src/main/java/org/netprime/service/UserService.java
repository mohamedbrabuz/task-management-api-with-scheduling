package org.netprime.service;


import org.netprime.dto.UserRequest;
import org.netprime.dto.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
    UserResponse updateUser(long id, UserRequest userRequest);
    UserResponse getUserByUsername(String username);
    void deleteUser(long id);
}
