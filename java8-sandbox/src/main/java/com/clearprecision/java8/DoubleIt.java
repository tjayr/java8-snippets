package com.clearprecision.java8;

import java.util.function.Function;

@FunctionalInterface
public interface DoubleIt extends Function<String, Boolean> {

		@Override
		public Boolean apply(String t);
		
		
	
}
