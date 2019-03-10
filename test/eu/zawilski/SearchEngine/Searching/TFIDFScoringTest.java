package eu.zawilski.SearchEngine.Searching;

import eu.zawilski.SearchEngine.Document;
import eu.zawilski.SearchEngine.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TFIDFScoringTest {
    private ScoringStrategy scoringStrategy;

    @BeforeEach
    void setUp() {
        scoringStrategy = new TFIDFScoring();
    }

    @Test
    void documentScorePositiveIfTermMeaningful() {
        int documentNumber = 0, termCount = 10, documentCount = 5;
        String name = "test.txt";
        List<Tuple> termInvertedIndex = new ArrayList<>();
        Document document = new Document(documentNumber, name, termCount);
        termInvertedIndex.add(new Tuple(0,1));
        termInvertedIndex.add(new Tuple(1,2));
        termInvertedIndex.add(new Tuple(1,3));
        termInvertedIndex.add(new Tuple(0,10));

        assertTrue(scoringStrategy.calculateDocumentScore(termInvertedIndex, document, documentCount) > 0);
    }

    @Test
    void documentScoreZeroIfTermMeaningless() {
        int documentNumber = 0, termCount = 10, documentCount = 4;
        String name = "test.txt";
        List<Tuple> termInvertedIndex = new ArrayList<>();
        Document document = new Document(documentNumber, name, termCount);
        termInvertedIndex.add(new Tuple(0,1));
        termInvertedIndex.add(new Tuple(1,2));
        termInvertedIndex.add(new Tuple(2,3));
        termInvertedIndex.add(new Tuple(3,10));

        assertEquals(0, scoringStrategy.calculateDocumentScore(termInvertedIndex, document, documentCount));
    }
}