package com.clearprecision.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileSorter {

	public void getData(List<String> input) {
		List<String> data = new ArrayList<>();
		data.addAll(input);
		data.forEach(item -> System.out.println(item));
	}
	
	
	public static void main(String[] args) {
		String[] data = {"1", "2", "3", "4"};
		FileSorter sorter = new FileSorter();
		sorter.getData(Arrays.asList(data));
	}

}
