package com.technomori.javastudy.collectionslab;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapsToMaps {

    public static void main(String[] args) {
        mapsToMaps();
    }

    private static void mapsToMaps() {
        Map<String, Integer> channelToSubscribers = new TreeMap<>(); // channelName, numSubscribers
        Map<String, String> channelToPublisher = new TreeMap<>(); // channelName, publisher
        Map<String, Integer> publisherToSubscribers = new TreeMap<>(); // publisher, numSubscribers

        // channel -> number of subscribers (K, V1)
        channelToSubscribers.put("JustForLaughs", 120_000);
        channelToSubscribers.put("JustForGags", 10_000);
        channelToSubscribers.put("ContemplationTechniques", 10_000);
        channelToSubscribers.put("A New Earth", 20_000);

        // channel -> publisher (K, V2)
        channelToPublisher.put("JustForLaughs", "Charlie Chaplin");
        channelToPublisher.put("JustForGags", "Charlie Chaplin");
        channelToPublisher.put("ContemplationTechniques", "Echhart Tolle");
        channelToPublisher.put("A New Earth", "Echhart Tolle");

        // 1. Using a forEach(BiConsumer), set up the publisherToSubscribers map.
        channelToPublisher.entrySet().stream().forEach(e -> {
            int subscribers = publisherToSubscribers.getOrDefault(e.getValue(), 0)
                    + channelToSubscribers.get(e.getKey());
            publisherToSubscribers.put(e.getValue(), subscribers);
        });

        // 2. Using a forEach(BiConsumer), output publisherToSubscribers.
        publisherToSubscribers.entrySet()
                .forEach(e -> System.out.println("Publisher: " + e.getKey() + "; numSubscribers: " + e.getValue()));

        // 3. Calculate the publisher with the most and least subscribers.
        Entry<String, Integer> mostSubscribers = publisherToSubscribers.entrySet().stream()
                .max((e1, e2) -> e1.getValue() - e2.getValue()).orElse(null);
        Entry<String, Integer> fewestSubscribers = publisherToSubscribers.entrySet().stream()
                .min((e1, e2) -> e1.getValue() - e2.getValue()).orElse(null);

        String stMostSubscribers = mostSubscribers == null ? "not found."
                : mostSubscribers.getKey() + " " + mostSubscribers.getValue();
        String stFewestSubscribers = fewestSubscribers == null ? "not found."
                : fewestSubscribers.getKey() + " " + fewestSubscribers.getValue();
        System.out.println("Publisher with most subscribers: " + stMostSubscribers);
        System.out.println("Publisher with most subscribers: " + stFewestSubscribers);
    }

}
