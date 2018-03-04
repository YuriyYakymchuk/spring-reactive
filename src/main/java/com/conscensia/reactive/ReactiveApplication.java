package com.conscensia.reactive;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Hooks;

import java.util.Locale;

@SpringBootApplication
public class ReactiveApplication {

	public static void main(String[] args) {
//		Hooks.onOperatorDebug();
		SpringApplication.run(ReactiveApplication.class, args);
	}

	@Bean
	public Faker faker() {
		return new Faker(new Locale("en"));
	}
}
