package org.netprime.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.netprime.model.User;

@NoArgsConstructor
public class UserResponse {

    private String username;
    private String name;

    public UserResponse toUserResponse(User user) {
        this.username = user.getUsername();
        this.name = user.getName();
        return this;
    }
}
