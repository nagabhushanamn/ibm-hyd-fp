package com.examples;

import java.util.function.Consumer;

public class Ex3 {

	public static void main(String[] args) {

		// A. anonymous-inner-class
		// -----------------------------------------------------------
		for (int i = 0; i < 5; i++) {
			Consumer<String> consumer = new Consumer<String>() {
				@Override
				public void accept(String t) {
					System.out.println("im - " + t);
				}
			};
			consumer.accept("aic " + consumer.toString());
		}
		// -----------------------------------------------------------
		System.out.println();
		
		// Non-capturing Lambda Expression
		// -----------------------------------------------------------
		for (int i = 0; i < 5; i++) {
			Consumer<String> consumer = (String t) -> {
				System.out.println("im - " + t);
			};
			consumer.accept("LE " + consumer.toString());
		}
		// -----------------------------------------------------------
		System.out.println();

		// final Local-var-capturing Lambda Expression
		// -----------------------------------------------------------
		final int local = 42;
		for (int i = 0; i < 5; i++) {
			Consumer<String> consumer = (String t) -> {
				System.out.println("im - " + t + " - " + local);
			};
			consumer.accept("LE " + consumer.toString());
		}

		// -----------------------------------------------------------
		System.out.println();
		// Local-var-capturing Lambda Expression
		// -----------------------------------------------------------
		int local2 = 42;
		for (int i = 0; i < 5; i++) {
			Consumer<String> consumer = (String t) -> {
				System.out.println("im - " + t + " - " + local2);
			};
			consumer.accept("LE " + consumer.toString());
		}

		// -----------------------------------------------------------

	}

}
