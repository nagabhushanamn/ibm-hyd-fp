package com.examples;

import java.util.function.Consumer;

// Variable capture

class Xyz {

	static int staVar = 1;
	int insVar;

	public Xyz(int insVar) {
		this.insVar = insVar;
	}

	Consumer<String> method() {
		final int locVar = 3;

		Consumer<String> consumer = s -> {
			System.out.println("im " + s);
			System.out.println("static var: " + staVar);
			System.out.println("instance var: " + insVar);
			System.out.println("local var " + locVar);
		};

		return consumer;

	}

}

public class Ex2 {

	public static void main(String[] args) {

		Xyz xyz = new Xyz(100);
		Consumer<String> consumer = xyz.method();

		consumer.accept("CONSUMER-1");
		Xyz.staVar = 11;
		consumer.accept("CONSUMER-1");

		System.out.println();

//		Xyz xyz2 = new Xyz(200);
//		Consumer<String> consumer2 = xyz2.method();
//		consumer2.accept("CONSUMER-2");

	}

}
