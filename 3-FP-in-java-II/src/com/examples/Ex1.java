package com.examples;

import java.util.function.Consumer;

class GreetLib {
	public static void greet(String message, Consumer<String> consumer) {
		System.out.println("==============================");
		consumer.accept(message);
		System.out.println("==============================");
	}
}

class Training {
	public static Consumer<String> doTeach(String sub) {
		System.out.println("teaching " + sub);
		String notes = sub + " - notes";
		System.out.println("teaching ends");
		return name -> System.out.println(name + " learning with " + notes);
	}
}

public class Ex1 {

	public static void main(String[] args) {

//		- A function can be stored in a variable or value

		Consumer<String> greet = message -> System.out.println("message : " + message);
		greet.accept("hello");
		greet.accept("ola");

		System.out.println();

//		- A parameter of a function can be a function

		GreetLib.greet("namasthe", m -> System.out.println("message: " + m));
		GreetLib.greet("gud mng", m -> System.out.println("wish: " + m));
		GreetLib.greet("gud noon", greet);

		System.out.println();

//		- The return value of a function can be a function

		Consumer<String> learnFunc = Training.doTeach("java8");
		learnFunc.accept("emp1");
		learnFunc.accept("emp2");

	}

}
