package com.java.test.junior.dto;

import com.java.test.junior.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserResponse {

    private Long id;
    private String username;
    private String email;

    public CreateUserResponse(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public static CreateUserResponse valueOf(User user) {
        return new CreateUserResponse(user.getId(), user.getUsername(), user.getEmail());
    }
}
