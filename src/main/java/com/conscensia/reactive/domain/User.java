package com.conscensia.reactive.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class User {

    private final String name;
    private final String surname;
    private final Date birthDay;

}
