package com.conscensia.reactive.subscriber;

import com.conscensia.reactive.publisher.user.UserSimplePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.scheduler.Schedulers;

import static com.conscensia.reactive.subscriber.SubscriberUtils.sleepThread;

@Component
public class SimpleSubscriber {

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
                    sleepThread();
                    System.out.println(String.format("Simple Subscriber. Thread: %s. %s", Thread.currentThread().getName(), user));
                },
                // On error handling
                error -> System.err.println("Error happened: " + error.getMessage()),
                // On complete handling
                () -> System.out.println("On complete action."));
    }

}
