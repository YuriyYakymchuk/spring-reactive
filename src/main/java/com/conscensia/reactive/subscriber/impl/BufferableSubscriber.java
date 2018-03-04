package com.conscensia.reactive.subscriber.impl;

import com.conscensia.reactive.publisher.user.UserInfinityPublisher;
import com.conscensia.reactive.subscriber.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.scheduler.Schedulers;

import static com.conscensia.reactive.subscriber.SubscriberUtils.sleepThread;

/**
 * Bufferable subscriber. Subscribes to a publisher and introduces a buffer. When the buffer capacity is reached then
 * data is produced by batch.
 *
 * Buffer can be introduced by capacity or time wait.
 */
@Component
public class BufferableSubscriber implements Subscriber{

    private final UserInfinityPublisher publisher;

    @Autowired
    public BufferableSubscriber(UserInfinityPublisher publisher) {
        this.publisher = publisher;
    }

    public void subscribe() {
        publisher
                .subscribeOn(Schedulers.newElastic("Java meet-up"))
                .take(20)
                .buffer(3)
                .subscribe(users -> {
                    System.out.println(String.format("Bufferable subscriber. Thread: %s. %s", Thread.currentThread().getName(), users));
                    sleepThread();
                });
    }
}
