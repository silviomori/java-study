package com.technomori.javastudy.StreamsLab;

import java.util.Optional;

public class Q2_1849 {

    public static void main(String[] args) {
        Optional<Double> price1 = Optional.ofNullable(20.0);
        price1.ifPresent(p -> System.out.println("Price1 - ifPresent: " + p));
        System.out.println("Price1 - orElse: " + price1.orElse(0d));
        System.out.println("Price1 - orElseGet: " + price1.orElseGet(() -> 0d));

        Optional<Double> price2 = Optional.ofNullable(null);
        System.out.println("Price2: " + price2);
        System.out.println("Price2 - isEmpty: " + (price2.isEmpty() ? "empty" : price2));
        price2.ifPresent(p -> System.out.println("Price2 - ifPresent: " + p)); // no output
        Double x = price2.orElse(44.0);
        System.out.println("Price2 - orElse: " + x);

        Optional<Double> price3 = Optional.ofNullable(null);
        Double z = price3.orElseThrow(() -> new RuntimeException("Bad Code"));
        System.out.println("Price3 - orElseThrow: " + z); // not executed
    }

}
