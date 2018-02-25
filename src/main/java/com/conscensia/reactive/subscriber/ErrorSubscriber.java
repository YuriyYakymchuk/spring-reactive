package com.conscensia.reactive.subscriber;

import com.conscensia.reactive.publisher.user.UserErrorPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.scheduler.Schedulers;

import static com.conscensia.reactive.subscriber.SubscriberUtils.sleepThread;

@Component
public class ErrorSubscriber {

    private final UserErrorPublisher publisher;

    @Autowired
    public ErrorSubscriber(UserErrorPublisher publisher) {
        this.publisher = publisher;
    }

    public void subscribe() {
        publisher.subscribeOn(Schedulers.elastic())
            .subscribe(
                user -> {
                    sleepThread();
                    System.out.println("Error Subscriber. " + user);
                },
                error -> System.err.println("Error happened: " + error.getMessage()),
                () -> System.out.println("On complete action."));
    }
}
