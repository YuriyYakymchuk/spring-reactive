package com.conscensia.reactive.subscriber;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class ZipSubscriber {

    public void subscribe() {
        Flux.zip(Flux.just("A", "A", "A"), Flux.just("B", "B", "B"), (a, b) -> a + b)
                .subscribe(result -> System.out.println("Zip subscriber. " + result));

    }
}
