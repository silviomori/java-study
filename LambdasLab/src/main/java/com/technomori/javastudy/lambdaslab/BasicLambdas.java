package com.technomori.javastudy.lambdaslab;

import java.util.function.Consumer;

import com.technomori.javastudy.lambdaslab.interfaces.Printable;

public class BasicLambdas {

	public static void main(String[] args) {
		BasicLambdas basicLambdas = new BasicLambdas();
		basicLambdas.consumer();
	}

	private void consumer() {
		Printable<String> printable = s -> System.out.println(s);
		printable.print("Printable lambda");
		
		Consumer<String> consumerPrintableLambdaExpression = s -> System.out.println(s);
		consumerPrintableLambdaExpression.accept("Consumer - Lambda Expression");
		
		Consumer<String> consumerPrintableMethodReference = System.out::println;
		consumerPrintableMethodReference.accept("Consumer - Method Reference");
	}

}
