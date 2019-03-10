package eu.zawilski.SearchEngine.Indexing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentFilterTest {

    @Test
    void basicFiltering() {
        String input = "A brown fox jumped over a brown dog? It's impossible!";
        String expected = "a brown fox jumped over a brown dog its impossible";
        DocumentFilter documentFilter = new DocumentFilter();
        assertEquals(expected, documentFilter.basicFiltering(input));
    }

}