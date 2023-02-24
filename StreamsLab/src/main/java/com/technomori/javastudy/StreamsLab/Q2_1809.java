package com.technomori.javastudy.StreamsLab;

import java.util.List;

public class Q2_1809 {
    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Thinking in Java", 30.0),
                new Book("Java in 24 hrs", 20.0),
                new Book("Java Recipes", 10.0));
        System.out.println("Average price: " + books.stream()
                .filter(book -> book.getPrice() > 10)
                .mapToDouble(Book::getPrice)
                .average().orElse(-1));
        System.out.println("Average price: " + books.stream()
                .filter(book -> book.getPrice() > 90)
                .mapToDouble(Book::getPrice)
                .average().orElse(-1));
    }
}
