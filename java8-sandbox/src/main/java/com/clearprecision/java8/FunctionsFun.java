package com.clearprecision.java8;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionsFun {

	public static void main(String[] args) {

		Function<Integer, Integer> square = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer t) {
				return t * t;
			}
		};

		square = (t) -> t * t;
		square.apply(5);

		Function<Integer, Integer> doubleIt = x -> x * 2;
		Function<Integer, Integer> trebleIt = x -> x * 3;
		Function<Integer, Integer> quadrupleIt = (Integer x) -> {
			return x * 4;
		};
		BiFunction<Integer, Double, BigDecimal> bif = (x, y) -> {
			return new BigDecimal(x * y);
		};

		Integer result = doubleIt.andThen(trebleIt).apply(10);
		Integer composed = doubleIt.compose(trebleIt).compose(quadrupleIt)
				.apply(10);

		Function<Integer, Integer> combined = doubleIt.compose(trebleIt)
				.compose(quadrupleIt);

		composed = combined.apply(10);

		System.out.println(result);
		System.out.println(composed);

		new FunkyInterFace() {

			@Override
			public void filter(String criteria) {
				System.out.println(criteria);
			}
		};

		List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		Collections.sort(data, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});

		data.sort((a, b) -> a.compareTo(b));
		

	}

}
