package com.conscensia.reactive.publisher.user;

import com.conscensia.reactive.domain.User;
import com.conscensia.reactive.provider.UserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;

import java.util.Objects;

import static com.conscensia.reactive.ThreadUtils.sleepThread;

/**
 * PUBLISHER == OBSERVABLE
 *
 * Implementation of {@link Flux} that produces {@link User} objects in an infinity loop.
 */
@Component
public class UserInfinityPublisher extends Flux<User> {

    private final UserProvider userProvider;

    @Autowired
    public UserInfinityPublisher(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    @Override
    public void subscribe(CoreSubscriber<? super User> observer) {
        while (true) {
            try {
                observer.onNext(userProvider.generateNextUser());
                sleepThread();
            } catch (Exception e) {
                observer.onError(e);
            }
        }
    }


}
