package com.zana.bookindex;

public class Page {
    private final int pageNumber;
    private final String content;

    public Page(int pageNumber, String content) {
        this.pageNumber = pageNumber;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public int getPageNumber() {
        return pageNumber;
    }
}
