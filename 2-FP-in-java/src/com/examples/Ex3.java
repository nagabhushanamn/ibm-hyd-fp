package com.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

// why FP

public class Ex3 {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("nveg");
		list.add("veg");
		list.add("veg");
		list.add("nveg");
		list.add("nveg");
		list.add("veg");
		list.add("nveg");
		list.add("veg");

		//----------------------------------------------------------------------------------
		// imperative style ( what + how )

//		Iterator<String> iterator = list.iterator();
//		while (iterator.hasNext()) {
//			String item = (String) iterator.next();
//			if (item.equals("nveg"))
//				iterator.remove();
//		}
//
//		System.out.println(list);
		
		//----------------------------------------------------------------------------------

		// declerative/function style ( what )

		list.removeIf(item -> item.equals("nveg"));
		System.out.println(list);

		
		//----------------------------------------------------------------------------------
	}

}
