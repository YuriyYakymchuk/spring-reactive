package com.conscensia.reactive.subscriber;

import lombok.SneakyThrows;

public class SubscriberUtils {

    @SneakyThrows(InterruptedException.class)
    public static void sleepThread() {
        Thread.sleep(500l);
    }
}
