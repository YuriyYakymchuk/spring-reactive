package com.conscensia.reactive.publisher.user;

import com.conscensia.reactive.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.util.Calendar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfinityPublisherTest {

    @Autowired
    private UserInfinityPublisher publisher;

    @Test
    public void testComplexPublisher() {
        Calendar ninetiesYear = Calendar.getInstance();
        ninetiesYear.set(Calendar.YEAR, 1990);

        Flux<User> emitter = publisher.subscribeOn(Schedulers.elastic())
                .filter(user -> user.getBirthDay().after(ninetiesYear.getTime()))
                .take(10);

        StepVerifier.create(emitter)
                .assertNext(user -> user.getBirthDay().after(ninetiesYear.getTime()))
                .expectNextCount(9)
                .expectComplete()
                .verify();

    }

}
