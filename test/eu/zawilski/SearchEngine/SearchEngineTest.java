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
        String[] args = {termFoundInAllDocuments, firstDocument, secondDocument};
        SearchEngine searchEngine = new SearchEngine();
        List<String> results = searchEngine.getResults(args);
        assertEquals(0, results.size());
    }

    @Test
    void termFoundInJustOneDocumentReturnsNonEmptyArray() {
        String termFoundOnlyInFirstDocuments = "hello";
        String[] args = {termFoundOnlyInFirstDocuments, firstDocument, secondDocument};
        SearchEngine searchEngine = new SearchEngine();
        List<String> results = searchEngine.getResults(args);
        assertNotEquals(0, results.size());
    }

    @Test
    void termNotFoundResultsInNull() {
        String termNotFound = "goodbye";
        String[] args = {termNotFound, firstDocument, secondDocument};
        SearchEngine searchEngine = new SearchEngine();
        List<String> results = searchEngine.getResults(args);
        assertNull(results);
    }
}