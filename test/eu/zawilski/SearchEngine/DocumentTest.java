package eu.zawilski.SearchEngine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentTest {

    private Document document;
    private int number = 0, termCount = 30;
    private String name = "test.txt";

    @BeforeEach
    void setUp() {
        document = new Document(number, name, termCount);
    }

    @Test
    void getName() {
        assertEquals(name, document.getName());
    }

    @Test
    void getNumber() {
        assertEquals(number,document.getNumber());
    }

    @Test
    void getTermCount() {
        assertEquals(termCount, document.getTermCount());
    }
}