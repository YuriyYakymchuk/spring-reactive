package com.conscensia.reactive.subscriber.impl;

import com.conscensia.reactive.domain.User;
import com.conscensia.reactive.publisher.user.UserInfinityPublisher;
import com.conscensia.reactive.subscriber.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import static com.conscensia.reactive.ThreadUtils.sleepThread;

/**
 * Cachable subscriber. Introduces cache on publisher which allows new subscribers to receive the same data from the
 * cache. It's configurable how many items should be cached.
 */
@Component
public class CacheableSubscriber implements Subscriber{

    private final UserInfinityPublisher publisher;

    @Autowired
    public CacheableSubscriber(UserInfinityPublisher publisher) {
        this.publisher = publisher;
    }

    public void subscribe() {
        Flux<User> cache = publisher
            .subscribeOn(Schedulers.elastic())
            .cache();

        cache.take(5)
             .subscribe(user -> {
                 System.out.println("Cachable subscriber. First subscriber. " + user);
                 sleepThread();
             });

        cache.take(5)
             .subscribe(user -> {
                 System.out.println("Cachable subscriber. Second subscriber. " + user);
                 sleepThread();
             });
    }
}
