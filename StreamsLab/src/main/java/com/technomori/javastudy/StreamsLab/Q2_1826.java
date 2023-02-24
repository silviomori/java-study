package com.technomori.javastudy.StreamsLab;

import java.util.Optional;

public class Q2_1826 {
    public static void main(String[] args) {
        System.out.println("Grade #1: " + getGrade(50).orElse("UNKNOWN"));

        System.out.print("Grade #2: ");
        getGrade(55).ifPresentOrElse(System.out::println, () -> System.out.println("Empty"));
    }

    public static Optional<String> getGrade(int marks) {
        return marks > 50 ? Optional.of("PASS") : Optional.ofNullable("FAIL");
    }
}
