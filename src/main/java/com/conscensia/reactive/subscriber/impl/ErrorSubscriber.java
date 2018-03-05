package com.conscensia.reactive.subscriber.impl;

import com.conscensia.reactive.publisher.user.UserErrorPublisher;
import com.conscensia.reactive.subscriber.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.scheduler.Schedulers;

import static com.conscensia.reactive.ThreadUtils.sleepThread;

@Component
public class ErrorSubscriber implements Subscriber{

    private final UserErrorPublisher publisher;

    @Autowired
    public ErrorSubscriber(UserErrorPublisher publisher) {
        this.publisher = publisher;
    }

    public void subscribe() {
        publisher.subscribeOn(Schedulers.elastic())
            .subscribe(
                user -> {
                    System.out.println("Error Subscriber. " + user);
                    sleepThread();
                },
                error -> System.err.println("Error happened: " + error.getMessage()),
                () -> System.out.println("On complete action."));
    }
}
