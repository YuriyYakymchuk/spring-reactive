package com.conscensia.reactive.service;

import com.conscensia.reactive.domain.User;
import com.conscensia.reactive.repository.UserReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UserService {

    private final UserReactiveRepository userRepository;

    @Autowired
    public UserService(UserReactiveRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Mono<User> createUser(User user) {
        return userRepository.save(user);
    }
}