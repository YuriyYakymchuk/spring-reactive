package com.conscensia.reactive.controller;

import com.conscensia.reactive.domain.User;
import com.conscensia.reactive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(path = "/reactive", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> getReactiveAllUsers() {
        return userService.getReactiveAllUsers();
    }

    @GetMapping
    public Flux<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public Mono<User> createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }
}