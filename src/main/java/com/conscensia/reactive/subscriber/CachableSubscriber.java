package com.conscensia.reactive.subscriber;

import com.conscensia.reactive.domain.User;
import com.conscensia.reactive.publisher.user.UserInfinityPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import static com.conscensia.reactive.subscriber.SubscriberUtils.sleepThread;

/**
 * Cachable subscriber. Introduces cache on publisher which allows new subscribers to receive the same data from the
 * cache. It's configurable how many items should be cached.
 */
@Component
public class CachableSubscriber {

    private final UserInfinityPublisher publisher;

    @Autowired
    public CachableSubscriber(UserInfinityPublisher publisher) {
        this.publisher = publisher;
    }

    public void subscribe() {
        Flux<User> cache = publisher
            .subscribeOn(Schedulers.elastic())
            .cache();

        System.out.println("First subscriber.");
        cache.take(5)
             .subscribe(user -> {
                 sleepThread();
                 System.out.println("Cachable subscriber. First subscriber. " + user);
             });

        System.out.println("Second subscriber.");
        cache.take(5)
             .subscribe(user -> {
                sleepThread();
                 System.out.println("Cachable subscriber. Second subscriber. " + user);
             });
    }
}
