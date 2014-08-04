package com.clearprecision.java8.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ConcurrencyProgram {


	public void start() throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(5);

		Future<String> submit = executor.submit(new Task());
		
		
		System.out.println(submit.get(9, TimeUnit.SECONDS));
		
		
		executor.awaitTermination(10, TimeUnit.SECONDS);
	}

	final class Task implements Callable<String> {

		@Override
		public String call() throws Exception {
			Thread.sleep(3000);
			return "" + System.currentTimeMillis();
		}

	}

	public static void main(String[] args) throws Exception {
		ConcurrencyProgram prog = new ConcurrencyProgram();
		prog.start();

	}

}
