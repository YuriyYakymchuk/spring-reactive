package com.conscensia.reactive;

import lombok.SneakyThrows;

public class ThreadUtils {

    @SneakyThrows(InterruptedException.class)
    public static void sleepThread() {
        Thread.sleep(500l);
    }
}
