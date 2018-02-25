package com.conscensia.reactive.publisher.user;

import com.conscensia.reactive.domain.User;
import com.conscensia.reactive.provider.UserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;

/**
 * PUBLISHER == OBSERVABLE
 *
 * Publisher produces a fixed amount of {@link User} data and then throws {@link NullPointerException}.
 */
@Component
public class UserErrorPublisher extends Flux<User> {

    private static final int NUMBER_OF_USERS = 10;

    private final UserProvider userProvider;

    @Autowired
    public UserErrorPublisher(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    @Override
    public void subscribe(CoreSubscriber<? super User> observer) {
        for (int i = 0; i < NUMBER_OF_USERS; i++) {
            observer.onNext(userProvider.generateNextUser());
        }

        observer.onError(new NullPointerException());
    }

}
