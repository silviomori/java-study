package com.technomori.javastudy.StreamsLab;

import java.util.Arrays;
import java.util.List;

public class Q2_1840 {

    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(11, 11, 22, 33, 33, 55, 66);

        System.out.println("Any match 11: " + ls.stream().distinct().anyMatch(n -> n == 11));
        System.out.println("None match %11>0: " + ls.stream().distinct().noneMatch(n -> n % 11 > 0));
    }

}
