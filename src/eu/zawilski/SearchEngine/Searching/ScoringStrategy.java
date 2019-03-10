package eu.zawilski.SearchEngine.Searching;

import eu.zawilski.SearchEngine.Tuple;
import eu.zawilski.SearchEngine.Document;

import java.util.List;

interface ScoringStrategy {
    List<SearchResult> getSearchResults(List<Tuple> termInvertedIndex, List<Document> documentsData);
    double calculateDocumentScore(List<Tuple> invertedIndex, Document document, int documentsCount);
}
