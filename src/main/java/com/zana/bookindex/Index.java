package com.zana.bookindex;

import java.util.*;

public class Index {
    private final Map<String, Set<Integer>> indices = new HashMap<>();

    public void addPage(String word, int pageNumber) {
        // If the word exists add the page number to the set.
        // Otherwise, make a new record and add a new empty set.
        if (indices.containsKey(word)) indices.get(word).add(pageNumber);
        else indices.put(word, new HashSet<>());
    }

    @Override
    public String toString() {
        // Used for testing. It might not be the best solution, but it suffices for now.
        return indices.toString();
    }
}
