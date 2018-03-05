package com.conscensia.reactive.subscriber.impl;

import com.conscensia.reactive.publisher.user.UserSimplePublisher;
import com.conscensia.reactive.subscriber.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.scheduler.Schedulers;

import static com.conscensia.reactive.ThreadUtils.sleepThread;

@Component
public class SimpleSubscriber implements Subscriber{

    private final UserSimplePublisher publisher;

    @Autowired
    public SimpleSubscriber(UserSimplePublisher publisher) {
        this.publisher = publisher;
    }

    public void subscribe() {
        publisher.subscribeOn(Schedulers.elastic())
             .subscribe(
                // On next handling
                user -> {
                    System.out.println(String.format("Simple Subscriber. Thread: %s. %s", Thread.currentThread().getName(), user));
                    sleepThread();
                },
                // On error handling
                error -> System.err.println("Error happened: " + error.getMessage()),
                // On complete handling
                () -> System.out.println("On complete action."),
                // On subscription handling
                subscription -> {
                    System.out.println("On subscription action.");
                    subscription.request(1);
                });
    }

}
