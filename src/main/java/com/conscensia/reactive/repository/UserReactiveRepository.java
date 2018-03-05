package com.conscensia.reactive.repository;

import com.conscensia.reactive.domain.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserReactiveRepository extends ReactiveCrudRepository<User, String> {

}
