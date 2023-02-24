package com.technomori.javastudy.StreamsLab;

import java.util.List;

public class Q2_1738 {

    public static void main(String[] args) {
        List<Integer> numbers1 = List.of(1, 2, 3);
        System.out.println("sum: " + numbers1.stream().mapToInt(i -> i).sum());
        System.out.println("max: " + numbers1.stream().mapToInt(i -> i).max().getAsInt());

        List<Person> people = List.of(
                new Person("Alan", "Burke", 22),
                new Person("Zoe", "Peters", 20),
                new Person("Peter", "Castle", 29));
        System.out.println("Oldest person: " + people.stream()
                .max((p1, p2) -> p1.getAge() - p2.getAge()).orElse(null));

        List<Integer> numbers2 = List.of(10, 47, 33, 23);
        System.out.println("max: " + numbers2.stream().reduce((n1, n2) -> n1 > n2 ? n1 : n2).orElse(null));
        System.out.println("max: " + numbers2.stream().reduce(0, (n1, n2) -> n1 > n2 ? n1 : n2));
    }

}
