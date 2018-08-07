package com.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

class ItemsUtil {
	public static String replace(String item) {
		return item.equals("biryani") ? "Nil" : item;
	}
}

class Employee {

	String name;
	double salary;

	public Employee() {
	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
	
	

}

public class Ex4 {

	public static void main(String[] args) {

//		Thread thread=Thread.currentThread();
//		System.out.println(thread.getName());
//		

		//

		Supplier<Thread> threadSupplier = () -> Thread.currentThread(); // Lambda syntax
		// or
		Supplier<Thread> supplier = Thread::currentThread; // Method reference
//		System.out.println(supplier.get().getName());

		// -------------------------------------------------------

		// when to use method-reference syntax?

		/*
		 * 
		 * when lambda-expression just invoking existing java-functionality
		 * 
		 */

		// -------------------------------------------------------

		List<String> menu = new ArrayList<String>();
		menu.add("idly");
		menu.add("biryani");
		menu.add("vada");
		menu.add("biryani");
		menu.add("porri");
		menu.add("biryani");
		menu.add("biryani");
		menu.add("dosa");

		String itemToReplace = "biryani";
//		-------------------------------------------------------
		// way-1 : local inner class
		// -------------------------------------------------------
		class ReplaceWithNil implements UnaryOperator<String> {
			@Override
			public String apply(String t) {
				if (t.equals(itemToReplace))
					return "Nil";
				else
					return t;
			}
		}
		ReplaceWithNil replaceWithNil = new ReplaceWithNil();
		menu.replaceAll(replaceWithNil);
		System.out.println(menu);
		// -------------------------------------------------------
		// way-2 : anonymous inner class
		// -------------------------------------------------------
		menu.replaceAll(new UnaryOperator<String>() {
			@Override
			public String apply(String t) {
				if (t.equals(itemToReplace))
					return "Nil";
				else
					return t;
			}
		});
		System.out.println(menu);
		// -------------------------------------------------------
		// way-3: : lambda with block statements
		// -------------------------------------------------------
		menu.replaceAll((String t) -> {
			if (t.equals(itemToReplace))
				return "Nil";
			else
				return t;
		});
		System.out.println(menu);
		// -------------------------------------------------------
		// way-4: lambda with single statement
		// -------------------------------------------------------
		menu.replaceAll((String t) -> t.equals(itemToReplace) ? "Nil" : t);
		System.out.println(menu);
		
		// or 
		
		menu.replaceAll((t) -> t.equals(itemToReplace) ? "Nil" : t);
		System.out.println(menu);
		
		// or
		
		menu.replaceAll(t -> t.equals(itemToReplace) ? "Nil" : t);
		System.out.println(menu);

		// -------------------------------------------------------
		// way-5: lambda with existing utility method
		// -------------------------------------------------------
		menu.replaceAll((String t) -> ItemsUtil.replace(t));
		System.out.println(menu);
		// -------------------------------------------------------
		// way-6: method reference
		// -------------------------------------------------------
		menu.replaceAll(ItemsUtil::replace);
		System.out.println(menu);
		// -------------------------------------------------------

		// Method Reference - advanced concepts

		// 1.instance methods

		// A. specified instance
		String s = "ibm";
		Supplier<Integer> intSupplier1 = () -> s.length(); // lambda syntax
		// or
		Supplier<Integer> intSupplier2 = s::length;
		System.out.println(intSupplier2.get());

		// B. un-specified instance
		Function<String, Integer> function = String::length;
		System.out.println(function.apply("ibm"));

		// 2. static method
		Function<Integer, String> formatFunc = String::valueOf;
		System.out.println(formatFunc.apply(123));

		BiFunction<Long, Long, Long> biFunction = Math::floorMod;

		// 3. constructor

		Supplier<Employee> empSupplier1 = () -> new Employee();
		Supplier<Employee> empSupplier2 = Employee::new;
		Function<String, Employee> empFunc = Employee::new;

		// -----------------------------------------------------
		
		
		List<Employee> employees=Arrays.asList(
				new Employee("A",1000),
				new Employee("B",2000),
				new Employee("C",3000),
				new Employee("D",5000),
				new Employee("E",2000),
				new Employee("F",6000)
				);
		
		
		employees
		.stream()
		.filter(e->e.getSalary()>3000)
		.map(e->e.getName())
		.forEach(name->System.out.println(name));
		
		// 
		
		employees
		.stream()
		.filter(e->e.getSalary()>3000)
		.map(Employee::getName)
		.forEach(System.out::println);

	}

}
