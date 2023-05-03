package com.technomori.javastudy.StreamsLab;

import java.util.List;

public class Q2_1810 {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Bob", 31),
                new Person("Paul", 32),
                new Person("John", 33));

        double avgAge = people.stream()
                .filter(p -> p.getAge() < 30)
                .mapToInt(Person::getAge)
                // .average().getAsDouble(); // NoSuchElementException
                .average().orElse(0);

        System.out.println("Average age: " + avgAge);
    }

}
