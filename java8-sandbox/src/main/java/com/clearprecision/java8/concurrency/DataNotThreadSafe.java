package com.clearprecision.java8.concurrency;

public class DataNotThreadSafe {

	private int counter;

	public void increase() {
		counter++;
	}

	public int get() {
		return counter;
	}

}
