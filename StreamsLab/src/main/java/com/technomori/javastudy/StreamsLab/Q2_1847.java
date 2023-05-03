package com.technomori.javastudy.StreamsLab;

import java.util.List;
import java.util.stream.Collectors;

public class Q2_1847 {

    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Gone with the wind", 5),
                new Book("Gone with the wind", 10),
                new Book("Atlas shrugged", 15));

        // IllegalStateException: Duplicate key
        // books.stream()
        // .collect(Collectors.toMap(Book::getTitle, Book::getPrice))
        // .forEach((t, p) -> System.out.println(t + "\t" + p));

        books.stream()
                .collect(Collectors.toMap(Book::getTitle, Book::getPrice, Math::min))
                .forEach((t, p) -> System.out.println(t + "\t" + p));
    }

}
