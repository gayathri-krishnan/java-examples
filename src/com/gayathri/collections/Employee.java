package com.gayathri.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//How can we make Employee immutable?
public class Employee {

	private int id;
	private String lastName;
	private String firstName;
	private String department;
	private double salary;

	public Employee(int id, String lastName, String firstName, String department, double salary) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.department = department;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public static void main(String args[]) {
		Employee john = new Employee(1, "Doe", "John", "Finance", 100);
		Employee jane = new Employee(2, "Doe", "Jane", "Finance", 200);
		Employee tom = new Employee(3, "Cat", "Tom", "Finance", 150);
		Employee jerry = new Employee(3, "Mouse", "Jerry", "IT", 200);
		List<Employee> employees = new ArrayList<>();
		employees.add(john);
		employees.add(jane);
		employees.add(tom);
		employees.add(jerry);

		Comparator<Employee> deptComparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getDepartment().compareTo(o2.getDepartment());
			}

		};

		Comparator<Employee> salaryComparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				if (o1.getSalary() == o2.getSalary()) {
					return 0;
				}
				if (o1.getSalary() < (o2.getSalary())) {
					return -1;
				}
				return 1;
			}

		};
		// Comparator Chaining
		employees.sort(deptComparator.thenComparing(salaryComparator));

		employees.stream().forEach(e -> System.out.println(e.getFirstName().concat(" ").concat(e.getLastName())));

	}

}
