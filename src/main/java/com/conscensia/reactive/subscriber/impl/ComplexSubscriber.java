package com.conscensia.reactive.subscriber.impl;

import com.conscensia.reactive.publisher.user.UserInfinityPublisher;
import com.conscensia.reactive.subscriber.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Calendar;

@Component
public class ComplexSubscriber implements Subscriber{

    private final UserInfinityPublisher publisher;

    @Autowired
    public ComplexSubscriber(UserInfinityPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void subscribe() {
        Calendar nintiesYear = Calendar.getInstance();
        nintiesYear.set(Calendar.YEAR, 1990);

        publisher.subscribeOn(Schedulers.elastic())
                .take(Duration.ofSeconds(10))
                .filter(user -> user.getBirthDay().after(nintiesYear.getTime()))
                .map(user -> "User name: " + user.getName() + " was born in " + user.getBirthDay())
                .subscribe(System.out::println);
    }
}
