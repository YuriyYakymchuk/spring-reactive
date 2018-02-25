package com.conscensia.reactive.provider;

import com.conscensia.reactive.domain.Street;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StreetProvider {

    private final Faker faker;

    @Autowired
    public StreetProvider(Faker faker) {
        this.faker = faker;
    }

    public Street generateNextStreet() {
        return Street.builder()
                     .name(faker.address().streetName())
                     .build();
    }
}
