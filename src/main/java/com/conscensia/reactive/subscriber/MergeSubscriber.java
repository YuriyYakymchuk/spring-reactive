package com.conscensia.reactive.subscriber;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class MergeSubscriber {

    public void subscribe() {
        Flux.merge(Flux.just("A", "A", "A"), Flux.just("B", "B", "B"))
                .subscribe(result -> System.out.println("Merge subscriber. " + result));
    }
}
