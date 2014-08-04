package com.clearprecision.java8.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsExamples {

    public static void main(String[] args) {

        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println("ForEach");
        data.forEach(item -> System.out.println(item));

        System.out.println("Filter");

        data.stream().filter(item -> item % 2 == 0).forEach(item -> System.out.println(item));

        System.out.println("Map");

        data.stream().map(item -> item * 2).filter(item -> item > 5).forEach(item -> System.out.println(item));

        Stream<Integer> stream = data.stream().map(item -> item * 2).filter(item -> item > 5);
        System.out.println(stream.collect(Collectors.counting()).intValue());

    }

}
