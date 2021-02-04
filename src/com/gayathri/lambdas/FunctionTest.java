package com.gayathri.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;

public class FunctionTest {

	public static void main(String[] args) {
		Emp john = new Emp("John Doe", 30);
		Emp tim = new Emp("Tim Buchalka", 21);
		Emp jack = new Emp("Jack Hill", 40);
		Emp snow = new Emp("Snow White", 22);
		Emp red = new Emp("Red RidingHood", 35);
		Emp charming = new Emp("Prince Charming", 31);

		List<Emp> employees = new ArrayList<>();
		employees.add(john);
		employees.add(tim);
		employees.add(jack);
		employees.add(snow);
		employees.add(red);
		employees.add(charming);

		Function<Emp, String> getLastName = (Emp employee) -> {
			return employee.getName().substring(employee.getName().indexOf(' ') + 1);
		};

		String lastName = getLastName.apply(employees.get(1));
//        System.out.println(lastName);

		Function<Emp, String> getFirstName = (Emp employee) -> {
			return employee.getName().substring(0, employee.getName().indexOf(' '));
		};

		Random random1 = new Random();
		for (Emp employee : employees) {
			if (random1.nextBoolean()) {
				System.out.println(getAName(getFirstName, employee));
			} else {
				System.out.println(getAName(getLastName, employee));
			}
		}

		Function<Emp, String> upperCase = employee -> employee.getName().toUpperCase();
		Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
		Function chainedFunction = upperCase.andThen(firstName);
		System.out.println(chainedFunction.apply(employees.get(0)));

		BiFunction<String, Emp, String> concatAge = (String name, Emp employee) -> {
			return name.concat(" " + employee.getAge());
		};

		String upperName = upperCase.apply(employees.get(0));
		System.out.println(concatAge.apply(upperName, employees.get(0)));

		IntUnaryOperator incBy5 = i -> i + 5;
		System.out.println(incBy5.applyAsInt(10));

		Consumer<String> c1 = s -> s.toUpperCase();
		Consumer<String> c2 = s -> System.out.println(s);
		c1.andThen(c2).accept("Hello, World!");

	}

	private static String getAName(Function<Emp, String> getName, Emp employee) {
		return getName.apply(employee);
	}

	private static void printEmployeesByAge(List<Emp> employees, String ageText, Predicate<Emp> ageCondition) {

		System.out.println(ageText);
		System.out.println("==================");
		for (Emp employee : employees) {
			if (ageCondition.test(employee)) {
				System.out.println(employee.getName());
			}
		}
	}
}

class Emp {
	private String name;
	private int age;

	public Emp(String name, int age) {
		this.name = name;
		this.age = age;
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
