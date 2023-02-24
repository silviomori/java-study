package com.technomori.javastudy.StreamsLab;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Q2_1787 {

    public static void main(String[] args) {
        Stream.of(Arrays.asList("a", "b"), Arrays.asList("a", "c"))
                .filter(list -> list.contains("c"))
                .flatMap(List::stream)
                .forEach(str -> System.out.print(str + " "));
    }

}
