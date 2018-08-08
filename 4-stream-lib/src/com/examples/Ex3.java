package com.examples;

import java.time.LocalDateTime;
import java.util.Objects;

// Lazy evaluation

public class Ex3 {

	public static void main(String[] args) {

		String s1 = "hello";
		String s2 = null;

		int h = computeHashingV2(s1, s2);
		System.out.println(h);

	}

	public static String getApplicationStatus() {
		// long running func...
		System.out.println("collectiong appln status");
		return "staus- " + LocalDateTime.now().toString();
	}

	private static int computeHashing(String s1, String s2) {
		Objects.requireNonNull(s1, getApplicationStatus());
		Objects.requireNonNull(s2, getApplicationStatus());
		return s1.hashCode() ^ s2.hashCode();
	}

	private static int computeHashingV2(String s1, String s2) {
		Objects.requireNonNull(s1, ()->getApplicationStatus());
		Objects.requireNonNull(s2, ()->getApplicationStatus());
		return s1.hashCode() ^ s2.hashCode();
	}

}
