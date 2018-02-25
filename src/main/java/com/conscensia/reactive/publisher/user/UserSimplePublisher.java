package com.conscensia.reactive.publisher.user;

import com.conscensia.reactive.domain.User;
import com.conscensia.reactive.provider.UserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;

import java.util.Objects;

/**
 * PUBLISHER == OBSERVABLE
 *
 * Implementation of {@link Flux} that produces the finite amount of {@link User} objects.
 */
@Component
public class UserSimplePublisher extends Flux<User> {

    private static final int NUMBER_OF_USERS = 10;

    private final UserProvider userProvider;

    @Autowired
    public UserSimplePublisher(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    @Override
    public void subscribe(CoreSubscriber<? super User> observer) {
        for (int i = 0; i < NUMBER_OF_USERS; i++) {
            try {
                User user = userProvider.generateNextUser();
                observer.onNext(user);
            } catch (Exception e) {
                observer.onError(e);
            }
        }
        observer.onComplete();
    }
}
