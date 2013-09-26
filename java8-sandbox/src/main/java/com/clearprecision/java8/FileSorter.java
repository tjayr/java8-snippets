package com.clearprecision.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FileSorter {

	public void foreach(List<String> input) {
        System.out.println("foreach >>>>>");
		List<String> data = new ArrayList<>();
		data.addAll(input);
		data.forEach(item -> System.out.println(item));
	}

    public void map(List<String> input) {
        System.out.println("map >>>>>");
        input.stream()
                .filter(p -> p.contains("hello"))
                .map(mapper -> mapper + " Jim")
                .forEach(item -> System.out.println(item));

    }
	
	
	public static void main(String[] args) {
		String[] data = {"hello", "2", "3", "4", "hello"};
		FileSorter sorter = new FileSorter();
		sorter.foreach(Arrays.asList(data));

        sorter.map(Arrays.asList(data));
	}

}
