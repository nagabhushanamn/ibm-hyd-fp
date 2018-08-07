package com.examples;

import java.util.ArrayList;
import java.util.List;

// why FP ?

public class Ex9 {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();

		list.add("veg");
		list.add("nveg");
		list.add("veg");
		list.add("veg");
		list.add("nveg");
		list.add("veg");
		list.add("veg");
		list.add("veg");
		list.add("nveg");

		list.replaceAll(item -> {
			return item.equals("nveg") ? "non-veg" : item;
		});

		System.out.println(list);

	}

}
