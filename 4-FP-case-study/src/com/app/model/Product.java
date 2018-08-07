package com.app.model;

import java.util.Random;
import java.util.stream.Stream;

public class Product {

	private int id;
	private String name;
	private double price;

	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	public static Product[] randomlyGenerate(int limit) {
		Random random = new Random(10000);
		return Stream.generate(() -> {
			int rn = random.nextInt();
			Product product = new Product(rn, "product-" + rn, 10 * rn);
			return product;
		}).limit(limit).toArray(Product[]::new);

	}

}
