package com.examples;

//-----------------------------------------------
// Type of LambdaExpression  ==> FunctionalInterface
//-----------------------------------------------
interface Adder {
	double add(double d1, double d2);
}

interface Joiner {
	String join(String s1, String s2);
}

//-----------------------------------------------

class BigDataLib {
	public double addNumbers(Adder adder) {
		double d1 = 12.0;
		double d2 = 13.0;
		return adder.add(d1, d2);
	}

	public String addStrings(Joiner joiner) {
		String s1 = "hello";
		String s2 = "world";
		return joiner.join(s1, s2);
	}
}

//-----------------------------------------------

class BigDataLibV2 {
	public double add(Adder adder) {
		double d1 = 12.0;
		double d2 = 13.0;
		return adder.add(d1, d2);
	}

	public String add(Joiner joiner) {
		String s1 = "hello";
		String s2 = "world";
		return joiner.join(s1, s2);
	}
}

//-----------------------------------------------

public class Ex6 {

	public static void main(String[] args) {

		// --------------------------------------------------

		BigDataLib bigDataLib = new BigDataLib();

		// way-1
//		Adder adder = (x, y) -> x + y - 100; // RHS context
//		double result = bigDataLib.addNumbers(adder);
//		System.out.println(result);Ï

		// way-2

		double result = bigDataLib.addNumbers((x, y) -> x + y); // parameter-context
		System.out.println(result);

		String greetString = bigDataLib.addStrings((x, y) -> x + y);
		System.out.println(greetString);

		// --------------------------------------------------

		BigDataLibV2 bigDataLibV2 = new BigDataLibV2();

		double result1 = bigDataLibV2.add((double x, double y) -> x + y);
		System.out.println(result1);

		String greetString1 = bigDataLibV2.add((Joiner) (x, y) -> x + y); // casting context
		System.out.println(greetString1);

	}

}
