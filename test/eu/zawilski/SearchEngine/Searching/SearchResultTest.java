package eu.zawilski.SearchEngine.Searching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchResultTest {

    private SearchResult searchResult;
    private String documentName = "test.txt";
    private double score = 0.12d, worseScore = 0.1d, betterScore = 0.2d;

    @BeforeEach
    void setUp() {
        searchResult = new SearchResult(documentName, score);
    }

    @Test
    void getScore() {
        assertEquals(score, searchResult.getScore());
    }

    @Test
    void getDocumentName() {
        assertEquals(documentName, searchResult.getDocumentName());
    }

    @Test
    void resultWithLowerScoreIsWorse() {
        SearchResult secondSearchResult = new SearchResult("", worseScore);
        assertTrue(searchResult.compareTo(secondSearchResult) < 0);
    }

    @Test
    void resultWithHigherScoreIsBetter() {
        SearchResult secondSearchResult = new SearchResult("", betterScore);
        assertTrue(searchResult.compareTo(secondSearchResult) > 0);
    }

    @Test
    void stringifiesToMessageWhenScorePositive() {
        String correctMessage = "Document " + documentName + " has a score of " + score;
        assertEquals(correctMessage, searchResult.toString());
    }

    @Test
    void stringifiesToEmptyStringWhenScoreNonPositive() {
        searchResult = new SearchResult(documentName, 0.0d);
        assertEquals("", searchResult.toString());
    }
}