package com.examples;

import java.util.Comparator;

/*
 * java-8 : interfaces got boost
 * 
 *  - default methods
 *  - static methods
 *  
 *  e.g
 *    
 *    Comparator<T>
 * 
 */

public class Ex4 {

	public static void main(String[] args) {

		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};

		String s1 = "hello";
		String s2 = "world";

		System.out.println(comparator.compare(s1, s2));

//		Comparator<String> reverseComparator = new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o2.compareTo(o1);
//			}
//		};

		Comparator<String> reverseComparator = comparator.reversed(); // default methodÏ
		System.out.println(reverseComparator.compare(s1, s2));

		String s3 = "hello";
		String s4 = null;

		Comparator<String> nullCheckComparator = Comparator.nullsLast(comparator);// static
		System.out.println(nullCheckComparator.compare(s3, s4));

	}

}
