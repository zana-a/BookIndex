package com.zana.bookindex;

import java.util.*;
import java.util.stream.Collectors;

public class Book {
    private final String title;
    private final List<Page> pages;

    public Book(String title, List<Page> pages) {
        this.title = title;
        this.pages = pages;
    }

    public HashMap<String, Set<Integer>> getIndexFor(Set<String> words) {
        var index = new HashMap<String, Set<Integer>>();

        for (var page : pages) {
            for (var word : words.stream().map(String::toLowerCase).collect(Collectors.toSet())) {
                if (!index.containsKey(word)) index.put(word.toLowerCase(), new HashSet<>());
                if (page.getContent().toLowerCase().contains(word)) index.get(word).add(page.getPageNumber());
            }
        }

        var indexStripped = new HashMap<String, Set<Integer>>();
        for (var entry : index.entrySet()) {
            if (!entry.getValue().isEmpty()) {
              indexStripped.put(entry.getKey(), entry.getValue());
            }
        }

        return indexStripped;
    }
}
