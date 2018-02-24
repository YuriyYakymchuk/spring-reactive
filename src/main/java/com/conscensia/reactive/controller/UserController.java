package com.conscensia.reactive.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping(value = "{id}")
    public ResponseEntity<String> getUser(@PathVariable final long id) {
        return new ResponseEntity<String>(String.format("Hello user: %d", id), HttpStatus.OK);
    }
}
