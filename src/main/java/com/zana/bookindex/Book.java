package com.zana.bookindex;

import java.util.List;

public class Book {
    private final List<Page> pages;

    public Book(List<Page> pages) {
        this.pages = pages;
    }

    public Index generateIndexFor(List<String> queriedWords) {
        var index = new Index();
        if (queriedWords.isEmpty()) return index;

        for (var page : pages) {
            var contentWords = page.getContentAsSet();
            for (var queriedWord : queriedWords) {
                if (contentWords.contains(queriedWord)) {
                    index.addPage(queriedWord, page.getPageNumber());
                }
            }
        }

        return index;
    }
}
