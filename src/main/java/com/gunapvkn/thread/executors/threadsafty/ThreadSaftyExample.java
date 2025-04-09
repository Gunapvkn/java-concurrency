package com.gunapvkn.thread.executors.threadsafty;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSaftyExample {
    private static int sheepCount;
    private static AtomicInteger sheepCountAtomic = new AtomicInteger(0);

    private void incrementAndReport() {
        System.out.print((++sheepCount) + " ");
    }

    private void incrementAtomicallyAndReport() {
        System.out.print((sheepCountAtomic.incrementAndGet()) + " ");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try (var executorService = Executors.newFixedThreadPool(10)) {
            ThreadSaftyExample manager = new ThreadSaftyExample();
            Future<?> result = null;
            for (var i = 0; i < 10; i++) {
                result = executorService.submit(manager::incrementAndReport);
            }
            result.get();
            System.out.println();
            for (var i = 0; i < 10; i++) {
                executorService.submit(manager::incrementAtomicallyAndReport);
            }
        }
    }
}
