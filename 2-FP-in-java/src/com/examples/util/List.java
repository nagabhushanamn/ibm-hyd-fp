package com.examples.util;

public interface List extends Collection {
	void add(int idx,String ele);
	default void forEach() {
		// ....
	};
}
