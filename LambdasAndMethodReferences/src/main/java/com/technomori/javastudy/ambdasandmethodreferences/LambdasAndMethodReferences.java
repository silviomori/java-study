package com.technomori.javastudy.ambdasandmethodreferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdasAndMethodReferences {
    public static void main(String[] args) {
        staticMR();
        boundMR();
        unboundMR();
        constructorMR();
    }

    private static void staticMR() {
        List<Integer> listOfIntegers = new ArrayList<>(List.of(1, 2, 7, 4, 5));
        Consumer<List<Integer>> consumerLambda = list -> Collections.sort(list);
        consumerLambda.accept(listOfIntegers);
        System.out.println(listOfIntegers);

        listOfIntegers = new ArrayList<>(List.of(1, 2, 7, 4, 5));
        Consumer<List<Integer>> consumerMR = Collections::sort;
        consumerMR.accept(listOfIntegers);
        System.out.println(listOfIntegers);
    }

    private static void boundMR() {
        String name = "Mr. Joe Bloggs";
        Predicate<String> predicateLambda = prefix -> name.startsWith(prefix);
        System.out.println(predicateLambda.test("Mr."));
        System.out.println(predicateLambda.test("Ms."));

        Predicate<String> predicateMR = name::startsWith;
        System.out.println(predicateMR.test("Mr."));
        System.out.println(predicateMR.test("Ms."));
    }

    private static void unboundMR() {
        Predicate<String> predicateLambda = str -> str.isEmpty();
        System.out.println(predicateLambda.test(""));
        System.out.println(predicateLambda.test("xyz"));

        Predicate<String> predicateMR = String::isEmpty;
        System.out.println(predicateMR.test(""));
        System.out.println(predicateMR.test("xyz"));

        BiPredicate<String, String> biPredicateLambda = (str1, str2) -> str1.startsWith(str2);
        System.out.println(biPredicateLambda.test("Mr. Joe Bloggs", "Mr."));
        System.out.println(biPredicateLambda.test("Mr. Joe Bloggs", "Ms."));

        BiPredicate<String, String> biPredicateMR = String::startsWith;
        System.out.println(biPredicateMR.test("Mr. Joe Bloggs", "Mr."));
        System.out.println(biPredicateMR.test("Mr. Joe Bloggs", "Ms."));
    }

    private static void constructorMR() {
        Supplier<List<String>> supplierLambda = () -> new ArrayList<>();
        List<String> listLambda = supplierLambda.get();
        listLambda.add("Lambda");
        System.out.println(listLambda);

        Supplier<List<String>> supplierMR = ArrayList::new;
        List<String> listMR = supplierMR.get();
        listMR.add("Method Reference");
        System.out.println(listMR);

        Function<Integer, List<String>> funcLambda = size -> new ArrayList<>(size);
        List<String> listLambda2 = funcLambda.apply(10);
        listLambda2.add("Lambda 2");
        System.out.println(listLambda2);

        Function<Integer, List<String>> funcMR = ArrayList::new;
        List<String> listMR2 = funcMR.apply(10);
        listMR2.add("Method Reference 2");
        System.out.println(listMR2);
    }
}
