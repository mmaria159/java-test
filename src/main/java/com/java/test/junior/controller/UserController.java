package com.java.test.junior.controller;

import com.java.test.junior.dto.CreateUserRequest;
import com.java.test.junior.dto.CreateUserResponse;
import com.java.test.junior.model.User;
import com.java.test.junior.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(CREATED)
    public CreateUserResponse createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        User user = createUserRequest.toUser();
        User savedUser = userService.createUser(user);
        return CreateUserResponse.valueOf(savedUser);
    }
}
