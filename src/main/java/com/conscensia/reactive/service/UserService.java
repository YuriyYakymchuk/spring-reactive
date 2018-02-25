package com.conscensia.reactive.service;

import com.conscensia.reactive.domain.User;
import com.conscensia.reactive.repository.UserRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> getAll() {
        return Flux.fromIterable(userRepository.findAll());
    }
}
