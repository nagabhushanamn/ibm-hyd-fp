package com.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex2 {

	public static void main(String[] args) {

		// way-1:
		Stream<Integer> stream1 = Stream.of(1, 1, 2, 3, 4, 8);

		// way-2:
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		Stream<Integer> stream2 = list.stream();

		// way-3:
		int[] nums = { 1, 2, 3, 4, 5, 6 };
		IntStream stream3 = Arrays.stream(nums);

		// way-4
		Random random=new Random();
		
		Stream<Integer> stream4=Stream.generate(random::nextInt);  // infinite
		
//		stream4
//		.filter(n->n>0)
//		.limit(10)
//		.forEach(System.out::println);
		
		//way-5
		
		Stream<Integer> stream5=Stream.iterate(10, n->n+1);
		stream5.forEach(System.out::println);

	}

}
