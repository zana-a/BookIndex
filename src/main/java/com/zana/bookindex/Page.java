package com.zana.bookindex;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Page {
    private final int pageNumber;
    private final String content;

    public Page(int pageNumber, String content) {
        this.pageNumber = pageNumber;
        this.content = content;
    }

    public Set<String> getContentAsSet() {
        // This may be slow down the Book#generateIndexFor method since this will need to go through each item to split
        // and then also create a set from the resulting split function. This would have a time complexity of O(n).
        return Arrays.stream(content.split(" ")).collect(Collectors.toSet());
    }

    public int getPageNumber() {
        return pageNumber;
    }
}
