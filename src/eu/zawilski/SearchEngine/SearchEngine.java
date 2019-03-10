package eu.zawilski.SearchEngine;

import eu.zawilski.SearchEngine.Indexing.DocumentProcessing;
import eu.zawilski.SearchEngine.Searching.Searching;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SearchEngine {
    private DocumentProcessing documentProcessing = new DocumentProcessing();
    private Searching searching = new Searching();
    private List<String> searchResults = null;

    public List<String> getResults(String[] args){
        String term = args[0].toLowerCase();

        String[] documents = Arrays.copyOfRange(args, 1, args.length);
        documentProcessing.processDocuments(documents);
        Map<String, List<Tuple>> invertedIndex = documentProcessing.getInvertedIndex();
        List<Document> documentsData = documentProcessing.getDocumentsData();

        try {
             searchResults = searching.searchSingleTerm(term, invertedIndex, documentsData);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
        return searchResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchEngine that = (SearchEngine) o;
        return Objects.equals(documentProcessing, that.documentProcessing) &&
                Objects.equals(searching, that.searching) &&
                Objects.equals(searchResults, that.searchResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentProcessing, searching, searchResults);
    }
}
