package com.examples;

import java.util.stream.IntStream;

public class Ex4 {

	public static void main(String[] args) {

		// -------------------------------------------------------------
		IntStream intStream = IntStream.of(1, 2, 4, 3, 5, 6, 7, 8);

//		intStream.filter(n -> {
//			System.out.println("filtering - " + n);
//			return n % 2 == 0;
//		}).limit(3).forEach(n -> System.out.println(n));

		// -------------------------------------------------------------

//		Streams can only be traversed once 		

		IntStream fibStream = IntStream.of(1, 1, 2, 3);
		IntStream shortFibStream = fibStream.limit(2);

		shortFibStream.forEach(n -> System.out.println(n));
		
		// -------------------------------------------------------------
		
		

	}

}
