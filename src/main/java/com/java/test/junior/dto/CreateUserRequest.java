package com.java.test.junior.dto;

import com.java.test.junior.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateUserRequest {
    @NotBlank(message = "Username is mandatory")
    private String username;

    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Password is mandatory")
    @Size(min = 4, max = 15,message = "Password must be between 4 to 15 characters")
    private String password;

    public User toUser() {
        return new User(
                username,
                email,
                password
        );
    }
}
