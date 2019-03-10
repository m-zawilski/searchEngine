package eu.zawilski.SearchEngine.Indexing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Tokenizer {
    List<String> tokenize(String input) {
        String[] termsArray = input.split(" ");
        ArrayList<String> terms = new ArrayList<>();
        Collections.addAll(terms, termsArray);
        return terms;
    }
}
