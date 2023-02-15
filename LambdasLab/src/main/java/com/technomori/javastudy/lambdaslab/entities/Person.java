package com.technomori.javastudy.lambdaslab.entities;

public class Person {
	private String name;
	private int age;
	private double height;
	
	public Person(String name, int age, double height) {
		this.name = name;
		this.age = age;
		this.height = height;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public double getHeight() {
		return height;
	}
	
	@Override
	public String toString() {
		return name + ", " + age + " yo, " + height + "m"; 
	}
}
