package com.examples;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

class Box<E> implements Iterable<E> {
	// items
	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public E next() {
				return null;
			}
		};
	}
}

public class Ex1 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Set<Integer> set = new TreeSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(6);
		set.add(7);
		set.add(8);
		set.add(9);
		set.add(10);

		// -------------------------------------------------------------
		// way-1 : external iteration using 'for-loop'
		// -------------------------------------------------------------
		int oddSum = 0;
		for (int i = 0; i < list.size(); i++) {
			int n = list.get(i);
			if (n % 2 != 0)
				oddSum += n;
		}
		System.out.println(oddSum);
		// -------------------------------------------------------------
		// way-2 : external iteration using 'iterator' object
		// -------------------------------------------------------------

		oddSum = 0;
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer n = (Integer) iterator.next();
			if (n % 2 != 0)
				oddSum += n;
		}
		System.out.println(oddSum);
		// -------------------------------------------------------------

		// -------------------------------------------------------------
		// way-3 : external iteration using 'for-each' loop in JDK 1.5
		// -------------------------------------------------------------

		oddSum = 0;
		for (int n : list) {
			if (n % 2 != 0)
				oddSum += n;
		}
		System.out.println(oddSum);

		// -------------------------------------------------------------

		Box<Integer> box = new Box();
		// ..

		for (int n : box) {

		}
		
		// -------------------------------------------------------------
		
			/*  problems with external iteration with data-sets
			 * 
			 * => by default, sequential process  
			 * => imperative style coding ( what & how mixed )
			 * => not good for parralell computation
			 * 
			 * 
			 *  soln : using stream -ibrary ( from JDK 8 )
			 * 
			 */
		
		// -------------------------------------------------------------
		// way-4 : using internal iteration with functions
		// -------------------------------------------------------------
		
		
		IntStream intStream=
		list
		.stream() // build
		.filter(n->{
			String name=Thread.currentThread().getName();
			System.out.println(name+"--> filtering - "+n);
			return n%2!=0;
		})
		.mapToInt(Integer::valueOf);
		
		oddSum=intStream.sum();
		System.out.println(oddSum);
		

	}

}
