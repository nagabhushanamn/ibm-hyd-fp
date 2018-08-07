package com.examples;

/*
 * 
 *   Function in java
 *   -----------------
 * 
 */

@FunctionalInterface
interface StringToIntMapper {
	int map(String s);
}

public class Ex5 {

	public static void main(String[] args) {

		// way-1
		// -----------------------------------------------------
//		StringToIntMapper mapper = new StringToIntMapper() {
//			@Override
//			public int map(String s) {
//				return s.length();
//			}
//		};
//		
		// -----------------------------------------------------

		// way-2
//		StringToIntMapper mapper = (String s) -> {
//			return s.length();
//		};

		// or

//		StringToIntMapper mapper = (s) -> {
//			return s.length();
//		};

		// or

//		StringToIntMapper mapper = s -> {
//			return s.length();
//		};

		// or

//		StringToIntMapper mapper = s -> s.length();

	}

}
