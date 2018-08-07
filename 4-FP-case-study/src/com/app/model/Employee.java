package com.app.model;

import java.time.LocalDate;
import java.util.Random;
import java.util.stream.Stream;

public class Employee {

	private int id;
	private String name;
	private double salary;
	private Gender gender;
	private LocalDate joinDate;

	public Employee() {
	}
	public Employee(int id, String name, double salary, Gender gender, LocalDate joinDate) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.gender = gender;
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", gender=" + gender + ", joinDate="+ joinDate + "]";
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public Gender getGender() {
		return gender;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}
	
	
	public static Employee[] randomlyGenerate(int limit) {
		Random random=new Random(10000);
		return Stream
		.generate(()->{
			int rn=random.nextInt();
			Employee employee=new Employee(rn, "employee-"+rn, 10*rn, Gender.MALE, LocalDate.now());
			return employee;
		})
		.limit(limit)
		.toArray(Employee[]::new);
		
	}
	

}
