package com.clearprecision.java8.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureProof {

    private List<Runnable> getJobs() {
        List<Runnable> tasks = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            tasks.add(() -> {
                double d = Math.random() * 100;
                double result = d * d + System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName() + " - " + result);
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        return tasks;
    }

    private List<Callable<Double>> getResultJobs() {
        List<Callable<Double>> tasks = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            tasks.add(() -> {
                System.out.println("Callable running on Thread[" + Thread.currentThread().getName() + "]");
                double d = Math.random();
                double result = d * d + System.currentTimeMillis();
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return result;
            });
        }
        return tasks;
    }

    public static void main(String[] args) {
        FutureProof proof = new FutureProof();
        ExecutorService fixedPoolService = Executors.newFixedThreadPool(15);
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        ExecutorService cachedPoolService = Executors.newCachedThreadPool();

        List<Runnable> runnables = proof.getJobs();
        runnables.forEach(task -> fixedPoolService.submit(task));

        List<Callable<Double>> callables = proof.getResultJobs();
        callables.stream().map(result -> cachedPoolService.submit(result)).forEach(callable -> {
            try {
                System.out.println("callable result " + callable.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        fixedPoolService.shutdown();
        singleThread.shutdown();
        cachedPoolService.shutdown();

    }
}
