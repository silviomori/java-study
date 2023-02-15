package com.technomori.javastudy.lambdaslab;

import java.util.function.Consumer;
import java.util.function.Supplier;

import com.technomori.javastudy.lambdaslab.interfaces.Printable;
import com.technomori.javastudy.lambdaslab.interfaces.Retrievable;

public class BasicLambdas {

	public static void main(String[] args) {
		BasicLambdas basicLambdas = new BasicLambdas();
		basicLambdas.consumer();
		basicLambdas.supplier();
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
}

