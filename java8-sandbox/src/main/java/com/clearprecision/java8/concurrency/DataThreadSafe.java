package com.clearprecision.java8.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class DataThreadSafe {

	private int counter;
	
	private AtomicInteger atomicInt = new AtomicInteger(0);

	public void increase() {
		synchronized (this) {
			counter++;	
		}
		
	}

	public synchronized int get() {
		return counter;
	}
	
	
	public void increaseAtomic() {
		atomicInt.incrementAndGet();
	}
	
	public int getAtomic() {
		return atomicInt.get();
	}

}
