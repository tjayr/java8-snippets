package com.clearprecision.java8.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sun.xml.internal.ws.util.CompletedFuture;

public class Java8Future {

    private List<CompletableFuture<Double>> getJobs(Executor executor) {

        List<CompletableFuture<Double>> tasks = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> {
                double d = Math.random() * 100;
                double result = d * d + System.currentTimeMillis();
                try {
                    Thread.sleep((long) Math.random() * 500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " - " + result);
                return result;
            }, executor);
            tasks.add(future);
        }
        return tasks;
    }

    public static void main(String[] args) {
        Java8Future java8future = new Java8Future();
        ExecutorService fixedPoolService = Executors.newFixedThreadPool(15);

        List<CompletableFuture<Double>> runnables = java8future.getJobs(fixedPoolService);
        runnables.stream().forEach(result -> {
            result.complete(-1.0);
            try {
                System.out.println(result.get());
            } catch (Exception e) {             
                e.printStackTrace();
            }
        });

        fixedPoolService.shutdown();

    }

}
