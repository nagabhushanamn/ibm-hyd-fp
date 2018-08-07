package com.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


// FP

public class Ex2 {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("b");
		list.add("a");

//		Comparator<String> c = new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o2.compareTo(o1);
//			}
//		};

		// or

//		Comparator<String> c =(String o1, String o2) -> {
//			return o2.compareTo(o1);
//		};

		// or

//		Comparator<String> c =( o1,  o2) -> {
//			return o2.compareTo(o1);
//		};

		// or

//		Comparator<String> c = (o1, o2) -> o2.compareTo(o1);
//		Collections.sort(list, c);

		// or

		Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
		System.out.println(list);

	}

}
