package com.technomori.javastudy.lambdaslab;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.technomori.javastudy.lambdaslab.entities.Person;
import com.technomori.javastudy.lambdaslab.interfaces.Evaluate;
import com.technomori.javastudy.lambdaslab.interfaces.Functionable;
import com.technomori.javastudy.lambdaslab.interfaces.Printable;
import com.technomori.javastudy.lambdaslab.interfaces.Retrievable;

public class BasicLambdas {

	public static void main(String[] args) {
		BasicLambdas basicLambdas = new BasicLambdas();
		basicLambdas.consumer();
		basicLambdas.supplier();
		basicLambdas.predicate();
		
		Predicate<Integer> predicateEven = n -> n % 2 == 0;
		System.out.println("Is 4 even? " + basicLambdas.check(4, predicateEven));
		System.out.println("Is 7 even? " + basicLambdas.check(7, predicateEven));
		
		Predicate<String> predicateBeginsWithMr = s -> s.startsWith("Mr.");
		System.out.println("Does \"Mr. Joe Bloggs\" starts with \"Mr.\"? " +
				basicLambdas.check("Mr. Joe Bloggs", predicateBeginsWithMr));
		System.out.println("Does \"Ms. Ann Bloggs\" starts with \"Mr.\"? " +
				basicLambdas.check("Ms. Ann Bloggs", predicateBeginsWithMr));
		
		Person personMike = new Person("Mike", 33, 1.8);
		Person personAnn = new Person("Ann", 13, 1.4);
		Predicate<Person> predicateAdult = p -> p.getAge() >= 18;
		System.out.println("Is Mike adult? " + basicLambdas.check(personMike, predicateAdult));
		System.out.println("Is Ann adult? " + basicLambdas.check(personAnn, predicateAdult));
		
		basicLambdas.function();
		
		List<Person> listPeople = getPeople();
		System.out.println("Sort people by Age:");
		basicLambdas.sortAge(listPeople);
		listPeople.forEach(System.out::println);
		
		System.out.println("Sort people by Name:");
		basicLambdas.sortName(listPeople);
		listPeople.forEach(System.out::println);
		
		System.out.println("Sort people by Height:");
		basicLambdas.sortHeight(listPeople);
		listPeople.forEach(System.out::println);		
	}

	private void consumer() {
		Printable<String> printable = s -> System.out.println(s);
		printable.print("Printable lambda");
		
		Consumer<String> consumerPrintableLambdaExpression = s -> System.out.println(s);
		consumerPrintableLambdaExpression.accept("Consumer - Lambda Expression");
		
		Consumer<String> consumerPrintableMethodReference = System.out::println;
		consumerPrintableMethodReference.accept("Consumer - Method Reference");
	}

	private void supplier() {
		Retrievable<Integer> retrievable = () -> 77;
		System.out.println("Retrievable: " + retrievable.retrieve());
		
		Supplier<Integer> supplier = () -> 77;
		System.out.println("Supplier: "+ supplier.get());
	}
	
	private void predicate() {
		Evaluate<Integer> evaluate = n -> n < 0;
		System.out.println("Evaluate: is -1 negative? "+evaluate.isNegative(-1));
		System.out.println("Evaluate: is +1 negative? "+evaluate.isNegative(1));
		
		Predicate<Integer> predicate = n -> n < 0;
		System.out.println("Predicate: is -1 negative? "+predicate.test(-1));
		System.out.println("Predicate: is +1 negative? "+predicate.test(1));
	}
	
	private <T> boolean check(T t, Predicate<T> predicate) {
		return predicate.test(t);
	}

	private void function() {
		Functionable<Integer, String> functionable = n -> "Number is: " + n;
		System.out.println("Functionable: " + functionable.applyThis(25));
		
		Function<Integer, String> function = n -> "Number is: " + n;
		System.out.println("Function: " + function.apply(25));
	}
	
	private static List<Person> getPeople() {
		List<Person> result = new ArrayList<>();
		result.add(new Person("Mike", 33, 1.8));
		result.add(new Person("Mary", 25, 1.4));
		result.add(new Person("Alan", 34, 1.7));
		result.add(new Person("Zoe", 30, 1.5));
		return result;
	}
	
	public void sortAge(List<Person> listPeople) {
		listPeople.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
	}
	
	public void sortName(List<Person> listPeople) {
		listPeople.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
	}
	
	public void sortHeight(List<Person> listPeople) {
		listPeople.sort((p1, p2) -> Double.compare(p1.getHeight(), p2.getHeight()));
	}
}

