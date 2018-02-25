package com.conscensia.reactive.repository;

import com.conscensia.reactive.domain.User;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    private final Faker faker;

    private List<User> data;

    private final static int NUMBER_OF_USERS = 10;

    public UserRepository(Faker faker) {
        this.faker = faker;
        data = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_USERS; i++) {
            data.add(User.builder()
                    .name(faker.name().firstName())
                    .surname(faker.name().lastName())
                    .birthDay(faker.date().birthday())
                    .build());
        }
    }

    public List<User> findAll() {
        return data;
    }
}
