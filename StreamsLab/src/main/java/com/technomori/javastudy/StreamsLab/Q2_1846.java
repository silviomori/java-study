package com.technomori.javastudy.StreamsLab;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q2_1846 {
    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Atlas Shrugged", 10.0),
                new Book("Freedom at Midnight", 5.0),
                new Book("Gone with the wind", 5.0));
        Map<String, Double> booksMap = books.stream()
                .collect(Collectors.toMap(Book::getTitle, Book::getPrice));
        booksMap.forEach((title, price) -> {
            if (title.startsWith("A")) {
                System.out.println(title + ": " + price);
            }
        });
    }
}
