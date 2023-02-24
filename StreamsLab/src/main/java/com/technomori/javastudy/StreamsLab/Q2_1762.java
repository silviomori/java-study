package com.technomori.javastudy.StreamsLab;

import java.util.List;

public class Q2_1762 {

    public static void main(String[] args) {
        List<Item> list = List.of(new Item(1, "Screw"), new Item(2, "Nail"), new Item(3, "Bolt"));
        list.stream().sorted((i1, i2) -> i1.getName().compareTo(i2.getName())).forEach(System.out::print);
    }

}
