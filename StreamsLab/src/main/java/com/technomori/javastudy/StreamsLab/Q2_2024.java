package com.technomori.javastudy.StreamsLab;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Q2_2024 {

    public static void main(String[] args) {
        double sum = DoubleStream.of(0, 2, 4).filter(n -> n % 2 == 1).sum();
        System.out.println("Sum of odd numbers: " + sum);

        OptionalDouble avg = Stream.of(1d, 3d).mapToDouble(n -> n).filter(n -> n % 2 == 0).average();
        System.out.println("Average of even numbers: " + avg.orElse(0));
    }

}
