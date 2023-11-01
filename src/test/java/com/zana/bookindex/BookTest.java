package com.zana.bookindex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book("Example", List.of(
                new Page(1, "This is an example test paragraph for page one"),
                new Page(2, "This is a test paragraph for this page two")
        ));
    }

    @Test
    void testIndexForExistingWords() {
        var expected = new HashMap<String, List<Integer>>();
        var actual = book.getIndexFor(Set.of("this", "example"));

        expected.put("this", List.of(1, 2));
        expected.put("example", List.of(1));

        assertEquals(expected.toString(), actual.toString());
    }


    @Test
    void testIndexForNonExistingWords() {
        var actual = book.getIndexFor(Set.of("fox", "dragon"));
        assertEquals(new HashMap<>().toString(), actual.toString());
    }
}
