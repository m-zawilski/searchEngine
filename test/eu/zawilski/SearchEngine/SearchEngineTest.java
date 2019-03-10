package eu.zawilski.SearchEngine;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchEngineTest {
    private String firstFile = "test/resultsTestSample1.txt";
    private String secondFile = "test/resultsTestSample2.txt";

    @Test
    void termFoundInAllFilesReturnsEmptyArray() {
        String termFoundInAllFiles = "world";
        String[] args = {termFoundInAllFiles, firstFile, secondFile};
        SearchEngine searchEngine = new SearchEngine();
        List<String> results = searchEngine.getResults(args);
        assertEquals(0, results.size());
    }

    @Test
    void termFoundInJustOneFileReturnsNonEmptyArray() {
        String termFoundOnlyInFirstFile = "hello";
        String[] args = {termFoundOnlyInFirstFile, firstFile, secondFile};
        SearchEngine searchEngine = new SearchEngine();
        List<String> results = searchEngine.getResults(args);
        assertNotEquals(0, results.size());
    }

    @Test
    void termNotFoundResultsInNull() {
        String termNotFound = "goodbye";
        String[] args = {termNotFound, firstFile, secondFile};
        SearchEngine searchEngine = new SearchEngine();
        List<String> results = searchEngine.getResults(args);
        assertNull(results);
    }
}