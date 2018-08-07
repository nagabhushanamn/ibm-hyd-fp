package com.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

// using built-in functional interfaces

public class Ex8 {

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

		String itemToRemove = "nveg";
		// ----------------------------------------------

		// way-1 :imperative style ( what + how )

//		Iterator<String> iterator = list.iterator();
//		while (iterator.hasNext()) {
//			String item = (String) iterator.next();
//			if (item.equals(itemToRemove))
//				iterator.remove();
//		}
//
//		System.out.println(list);
//		
		// ----------------------------------------------

		// way-2 : declarative style using Local inner-class

//		class NVegCondition implements Predicate<String> {
//			@Override
//			public boolean test(String t) {
//				return t.equals(itemToRemove);
//			}
//		}
//		NVegCondition nVegCondition = new NVegCondition();
//		list.removeIf(nVegCondition);

		// ----------------------------------------------

		// way-3 : declarative style using Anonymous inner-class

//		list.removeIf(new Predicate<String>() {
//			@Override
//			public boolean test(String t) {
//				return t.equals(itemToRemove);
//			}
//		});

		// ----------------------------------------------
		
		// way-4 : declarative/functional style using lambda-expression ( function )

//		Predicate<String> nVegCondition = item -> item.equals(itemToRemove);
//		list.removeIf(nVegCondition);
		
		// or
		
		list.removeIf(item -> item.equals(itemToRemove));
		
		// ----------------------------------------------

		
	}

}
