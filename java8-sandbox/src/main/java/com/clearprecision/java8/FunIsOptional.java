package com.clearprecision.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FunIsOptional {

	public Optional<String> callService() {
		String result = null; // call some service maybe?
		return Optional.ofNullable(result);
	}

	public Optional<String> callService(String data) {
		if (data.length() < 100) {
			return Optional.empty();
		}
		return callService();
		
	}

	public Optional<String> callService(Integer data) {
		return Optional.of("" + data);
	}

	public Optional<List<String>> callServiceToGetList() {
		return Optional.of(Arrays.asList("1", "2", "3", "4"));
	}

	public static void main(String[] args) {

		FunIsOptional funIs = new FunIsOptional();

		Optional<String> result1 = funIs.callService();
		if (result1.isPresent()) {
			System.out.println(result1.get());
		}

		String result2 = funIs.callService("abcdefg").orElse("defaultValue");
		System.out.println(result2);

		String result3 = funIs.callService().orElseThrow(
				() -> new IllegalArgumentException("Nothing found"));
		System.out.println(result3);

		String result4 = funIs.callService(Integer.valueOf(1000)).orElse(null);
		System.out.println(result4);

		List<String> result5 = funIs.callServiceToGetList()
				.filter(p -> p.contains("1")).orElse(Arrays.asList("2"));
		System.out.println(result5);

	}

}
