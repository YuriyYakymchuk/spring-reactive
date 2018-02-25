package com.conscensia.reactive.subscriber;

import com.conscensia.reactive.publisher.user.UserInfinityPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

import static com.conscensia.reactive.subscriber.SubscriberUtils.sleepThread;

@Component
public class BackPressureSubscriber {

    private final UserInfinityPublisher publisher;

    @Autowired
    public BackPressureSubscriber(UserInfinityPublisher publisher) {
        this.publisher = publisher;
    }

    public void subscribe() {
           publisher.subscribeOn(Schedulers.elastic())
                .onBackpressureBuffer(5)
                .subscribe(
                    user -> {
                        sleepThread();
                        System.out.println("Back Pressure subscriber. " + user);
                    },
                    error -> System.out.println("Error happened: " + error.getMessage()),
                    () -> System.out.println("On complete action."),
                    subscription -> subscription.request(1));
    }
}
