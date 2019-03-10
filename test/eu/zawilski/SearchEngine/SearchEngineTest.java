package eu.zawilski.SearchEngine;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchEngineTest {
    private String firstDocument = "test/resultsTestSample1.txt";
    private String secondDocument = "test/resultsTestSample2.txt";

    @Test
    void termFoundInAllDocumentsReturnsEmptyArray() {
        String termFoundInAllDocuments = "world";
        String[] documents = {firstDocument, secondDocument};
        SearchEngine searchEngine = new SearchEngine();
        List<String> results = searchEngine.getResults(termFoundInAllDocuments, documents);
        assertEquals(0, results.size());
    }

    @Test
    void termFoundInJustOneDocumentReturnsNonEmptyArray() {
        String termFoundOnlyInFirstDocument = "hello";
        String[] documents = {firstDocument, secondDocument};
        SearchEngine searchEngine = new SearchEngine();
        List<String> results = searchEngine.getResults(termFoundOnlyInFirstDocument, documents);
        assertNotEquals(0, results.size());
    }

    @Test
    void termNotFoundResultsInNull() {
        String termNotFound = "goodbye";
        String[] documents = {firstDocument, secondDocument};
        SearchEngine searchEngine = new SearchEngine();
        List<String> results = searchEngine.getResults(termNotFound, documents);
        assertNull(results);
    }
}