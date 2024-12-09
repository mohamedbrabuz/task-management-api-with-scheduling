package org.netprime.dto;

import lombok.Data;
import org.netprime.model.User;

@Data
public class UserResponse {

    private String username;
    private String name;

    public UserResponse toUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(user.getUsername());
        userResponse.setName(user.getName());
        return userResponse;
    }
}
