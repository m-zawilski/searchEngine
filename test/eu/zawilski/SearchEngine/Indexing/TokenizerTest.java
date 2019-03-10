package eu.zawilski.SearchEngine.Indexing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TokenizerTest {

    @Test
    void splitsStringBySpace() {
        Tokenizer tokenizer = new Tokenizer();
        String input = "brown fox lazy dog";
        ArrayList<String> terms = new ArrayList<>();

        terms.add("brown");
        terms.add("fox");
        terms.add("lazy");
        terms.add("dog");

        assertEquals(terms, tokenizer.tokenize(input));
    }
}