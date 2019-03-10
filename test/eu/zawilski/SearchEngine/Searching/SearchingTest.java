package eu.zawilski.SearchEngine.Searching;

import eu.zawilski.SearchEngine.Document;
import eu.zawilski.SearchEngine.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SearchingTest {
    private String meaningfulTerm, meaninglessTerm, nonExistingTerm;
    private Map<String, List<Tuple>> invertedIndex;
    private List<Document> documentsData;
    private Searching searching;

    @BeforeEach
    void setUp() {
        searching = new Searching();
        meaningfulTerm = "hello";
        meaninglessTerm = "the";
        nonExistingTerm = "goodbye";
        List<Tuple> meaningfulTermInvertedIndex = new ArrayList<>();
        meaningfulTermInvertedIndex.add(new Tuple(0, 0));
        meaningfulTermInvertedIndex.add(new Tuple(0,2));
        meaningfulTermInvertedIndex.add(new Tuple(1,2));
        meaningfulTermInvertedIndex.add(new Tuple(1,3));


        List<Tuple> meaninglessTermInvertedIndex = new ArrayList<>();
        meaninglessTermInvertedIndex.add(new Tuple(0, 0));
        meaninglessTermInvertedIndex.add(new Tuple(0,2));
        meaninglessTermInvertedIndex.add(new Tuple(1,2));
        meaninglessTermInvertedIndex.add(new Tuple(2,3));

        invertedIndex = new HashMap<>();
        invertedIndex.put(meaningfulTerm, meaningfulTermInvertedIndex);
        invertedIndex.put(meaninglessTerm, meaninglessTermInvertedIndex);

        documentsData = new ArrayList<>();
        documentsData.add(new Document(0, "1", 10));
        documentsData.add(new Document(1, "2", 5));
        documentsData.add(new Document(2, "3", 4));
    }

    @Test
    void searchingMeaningfulTermResultsInNonEmptyArray() {
        List<String> results = searching.searchSingleTerm(meaningfulTerm, invertedIndex, documentsData);
        assertTrue(!results.isEmpty());
    }

    @Test
    void searchingMeaninglessTermResultsInEmptyArray() {
        List<String> results = searching.searchSingleTerm(meaninglessTerm, invertedIndex, documentsData);
        assertTrue(results.isEmpty());
    }

    @Test
    void searchingNonExistingTermThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> searching.searchSingleTerm(nonExistingTerm, invertedIndex, documentsData));
    }
}