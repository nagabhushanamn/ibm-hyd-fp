package com.examples;

// understanding built-in functional interfaces

import java.util.function.*;

public class Ex7 {

	public static void main(String[] args) {

		// -----------------------------------------------------------

		Predicate<String> isValid = s -> s.length() == 3;

		Consumer<String> consumer = s -> System.out.println(s);
		BiConsumer<String, String> biConsumer = (s1, s2) -> System.out.println(s1 + s2);

		Supplier<String> supplier = () -> "hello";

		Function<String, Integer> function = s -> s.length();
		BiFunction<String, String, Integer> biFunction = (s1, s2) -> s1.length() + s2.length();

		UnaryOperator<String> unaryOperator = s -> s.toUpperCase();
		BinaryOperator<String> binaryOperator = (s1, s2) -> s1 + s2;

		// -----------------------------------------------------------

//		BinaryOperator<Integer> add = (n1, n2) -> n1 + n2;
//		int result = add.apply(12, 13);
//		System.out.println(result);

		// -----------------------------------------------------------

		IntBinaryOperator add = (n1, n2) -> n1 + n2;
		int r = add.applyAsInt(12, 13);
		System.out.println(r);

		ToIntFunction<String> toIntFunction = s -> s.length();

	}

}
