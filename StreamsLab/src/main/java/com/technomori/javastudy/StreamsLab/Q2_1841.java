package com.technomori.javastudy.StreamsLab;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Q2_1841 {

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger();
        Stream<Integer> paralellStream = Stream.of(11, 11, 22, 33).parallel();

        paralellStream
                .filter(n -> {
                    ai.incrementAndGet();
                    return n % 2 == 0;
                })
                .forEach(System.out::println);

        System.out.println("AtomicInteger value: " + ai);
    }

}
