package com.gayathri.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1, "Larry", 32));
		employees.add(new Employee(1, "Tom", 20));
		employees.add(new Employee(1, "Harry", 33));
		
		employees.forEach(e->{
			System.out.println("Welcome aboard " + e.getName());
		});
		
		printByAge(employees, "Employees over 30", e -> e.getAge()>30);
		
		//Function Test
		Function <Employee, String> getLastName = (Employee e) ->{
			return e.getName().substring(e.getName().indexOf(' ')+ 1);
		};
		
		System.out.println(getLastName.apply(new Employee(4, "John Doe", 45)));
		
	}
	
	private static void printByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
		System.out.println(ageText);
		for(Employee e:employees) {
			if(ageCondition.test(e)) {
				System.out.println("You are precious! " + e.getName());
			}
		}
	}
}

class Employee{
	private int id;
	private String name;
	private int age;
	
	Employee(int id, String name, int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}