package com.app;

import com.app.model.Employee;
import com.app.model.Product;

public class App {

	public static void main(String[] args) {

		// ---------------------------------------------------
		Employee[] employees = Employee.randomlyGenerate(100);
		Product[] products = Product.randomlyGenerate(100);
		// ---------------------------------------------------

		// Ex. print top 10 employee's names where salary > 5000

		// Ex. print top 20 products where price < 5000

	}

}
