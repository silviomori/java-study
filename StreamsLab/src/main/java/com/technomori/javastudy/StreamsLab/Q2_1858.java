package com.technomori.javastudy.StreamsLab;

import java.util.ArrayList;
import java.util.List;

public class Q2_1858 {

    public static void main(String[] args) {
        List<AnotherBook> books = List.of(
                new AnotherBook("Gone with the wind", "Fiction"),
                new AnotherBook("Bourne Ultimatum", "Thriller"),
                new AnotherBook("The Client", "Thriller"));

        List<String> genreList = new ArrayList<>();
        // books.stream().forEach(b -> genreList.add(b.getGenre()));
        books.stream().map(AnotherBook::getGenre).forEach(genreList::add);
        System.out.println("Genre list: " + genreList);
    }

}
