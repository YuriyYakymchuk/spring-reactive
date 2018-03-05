package com.conscensia.reactive.service;

import com.conscensia.reactive.domain.User;
import com.conscensia.reactive.publisher.user.UserInfinityPublisher;
import com.conscensia.reactive.repository.UserReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
public class UserService {

    private final UserReactiveRepository userRepository;

    private final UserInfinityPublisher userPublisher;

    @Autowired
    public UserService(UserReactiveRepository userRepository, UserInfinityPublisher userPublisher) {
        this.userRepository = userRepository;
        this.userPublisher = userPublisher;
    }

    public Flux<User> getReactiveAllUsers() {
        Flux<User> users = userPublisher.subscribeOn(Schedulers.elastic())
                                        .take(20);
        return users;
    }

    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Mono<User> createUser(User user) {
        return userRepository.save(user);
    }
}