package com.conscensia.reactive.provider;

import com.conscensia.reactive.domain.User;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserProvider {

    private Faker faker;

    @Autowired
    public UserProvider(Faker faker) {
        this.faker = faker;
    }

    public User generateNextUser() {
        return User.builder()
                   .name(faker.name().firstName())
                   .surname(faker.name().lastName())
                   .birthDay(faker.date().birthday())
                   .build();
    }
}
