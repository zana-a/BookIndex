package com.zana.bookindex;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    private final Book book = new Book(List.of(
            new Page(1, "this is an example test paragraph for page one"),
            new Page(2, "this is a test paragraph for page two")
    ));

    @Test
    void testIndexForExistingWords() {
        var expected = new Index();
        var actual = book.generateIndexFor(List.of("this", "example"));

        expected.addPage("this", 1);
        expected.addPage("this", 2);
        expected.addPage("example",1);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void testIndexForNonExistingWords() {
        var actual = book.generateIndexFor(List.of("fox", "dragon"));
        assertEquals(new Index().toString(), actual.toString());
    }
}
