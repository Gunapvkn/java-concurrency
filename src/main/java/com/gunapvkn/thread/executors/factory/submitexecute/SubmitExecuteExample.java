package com.gunapvkn.thread.executors.factory.submitexecute;

import java.util.concurrent.*;

public class SubmitExecuteExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        try (var executorService = Executors.newSingleThreadExecutor()) {
            System.out.println("Start");
            executorService.execute(() -> System.out.println("Task 1"));
            Future<?> response = executorService.submit(() -> System.out.println("Task 2"));
            if (response.isDone()) {
                System.out.println("Thread is completed");
            } else {
                var result = response.get(10, TimeUnit.SECONDS);
                System.out.println("Thread is completed only after waiting for the result and should be null : " + result);
            }
        }
    }
}
