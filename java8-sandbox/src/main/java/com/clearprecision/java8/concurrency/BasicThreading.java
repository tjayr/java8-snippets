package com.clearprecision.java8.concurrency;

public class BasicThreading {

	public static void main(String[] args) {

		DataNotThreadSafe data = new DataNotThreadSafe();

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i < 10; i++) {
					data.increase();
					System.out.println(Thread.currentThread().getName() + " - "
							+ data.get());
				}
			}
		};

		Thread t1 = new Thread(runnable, "t1");
		Thread t2 = new Thread(runnable, "t2");

		t1.start();
		t2.start();
	}

}
