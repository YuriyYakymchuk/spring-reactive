package com.conscensia.reactive.subscriber.impl;

import com.conscensia.reactive.subscriber.Subscriber;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class ZipSubscriber implements Subscriber {

    @Override
    public void subscribe() {
        Flux.zip(Flux.just("A", "A", "A"), Flux.just("B", "B", "B"), (source1, source2) -> source1 + source2)
                .subscribe(result -> System.out.println("Zip subscriber. " + result));
    }
}
