package com.conscensia.reactive.subscriber.impl;

import com.conscensia.reactive.subscriber.Subscriber;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class MergeSubscriber implements Subscriber{

    public void subscribe() {
        Flux.merge(Flux.just("A", "A", "A"), Flux.just("B", "B", "B"))
                .subscribe(result -> System.out.println("Merge subscriber. " + result));
    }
}
