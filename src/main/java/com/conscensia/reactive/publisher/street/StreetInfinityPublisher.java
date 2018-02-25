package com.conscensia.reactive.publisher.street;

import com.conscensia.reactive.domain.Street;
import com.conscensia.reactive.provider.StreetProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;

@Component
public class StreetInfinityPublisher extends Flux<Street> {

    private final StreetProvider provider;

    @Autowired
    public StreetInfinityPublisher(StreetProvider provider) {
        this.provider = provider;
    }

    @Override
    public void subscribe(CoreSubscriber<? super Street> observer) {
        while (true) {
            try {
                observer.onNext(provider.generateNextStreet());
            } catch (Exception e) {
                observer.onError(e);
            }
        }
    }
}
