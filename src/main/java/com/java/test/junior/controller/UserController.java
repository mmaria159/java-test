package com.java.test.junior.controller;

import com.java.test.junior.dto.UserDto;
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

    @PostMapping
    @ResponseStatus(CREATED)
    public User createUser(@Valid @RequestBody UserDto userDto) {
        User user = userDto.toUser();
        return userService.createUser(user);
    }
}
