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
        long start = System.currentTimeMillis();
        input.stream().parallel()
                .filter(p -> p.contains("hello"))
                .map(mapper -> mapper + " Jim")
                .forEach(item -> System.out.println(item));
        System.out.println("map executed in " +(System.currentTimeMillis() - start)+" ms");

    }

    public void parallelMap(List<String> input) {
        System.out.println("parallel map >>>>>");
        long start = System.currentTimeMillis();
        input.stream().parallel()
                .filter(p -> p.contains("hello"))
                .map(mapper -> mapper + " Jim")
                .forEach(item -> System.out.println(item));

        System.out.println("parallelMap executed in " +(System.currentTimeMillis() - start)+" ms");
    }
	
	
	public static void main(String[] args) {
		String[] data = {"hello", "2", "3", "4", "hello"};
		FileSorter sorter = new FileSorter();
        List<String> listData = Arrays.asList(data);
		sorter.foreach(listData);
        sorter.map(listData);
        sorter.parallelMap(listData);
	}

}
