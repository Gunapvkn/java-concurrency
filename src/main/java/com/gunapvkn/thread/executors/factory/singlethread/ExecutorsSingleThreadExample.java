package com.gunapvkn.thread.executors.factory.singlethread;

import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ExecutorsSingleThreadExample {
    public static void main(String[] args) {
        try (var executorService = Executors.newSingleThreadExecutor()) {
            System.out.println("Start");
            executorService.submit(() -> System.out.println("Task 1"));
            executorService.submit(() -> {
                IntStream.range(0, 10).forEach(i -> System.out.println("Task 2, count " + i));
            });
            executorService.submit(() -> System.out.println("Task 3"));
            System.out.println("end");
        }
    }
}
