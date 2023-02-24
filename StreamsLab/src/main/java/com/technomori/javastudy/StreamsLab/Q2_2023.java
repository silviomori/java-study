package com.technomori.javastudy.StreamsLab;

import java.util.stream.IntStream;

public class Q2_2023 {

    public static void main(String[] args) {
        System.out.println(IntStream.range(0, 5).average().orElse(0));
    }

}
