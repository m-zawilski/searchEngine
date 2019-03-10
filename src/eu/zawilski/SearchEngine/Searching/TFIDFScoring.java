package eu.zawilski.SearchEngine.Searching;

import eu.zawilski.SearchEngine.Document;
import eu.zawilski.SearchEngine.Tuple;

import java.util.*;

class TFIDFScoring implements ScoringStrategy {
    @Override
    public List<SearchResult> getSearchResults(List<Tuple> termInvertedIndex, List<Document> documentsData) {
        ArrayList<SearchResult> searchResults = new ArrayList<>();
        for(Document document : documentsData){
            double documentScore = calculateDocumentScore(termInvertedIndex, document, documentsData.size());
            searchResults.add(new SearchResult(document.getName(), documentScore));
        }
        Collections.sort(searchResults);
        return searchResults;
    }

    @Override
    public double calculateDocumentScore(List<Tuple> invertedIndex, Document document, int documentsCount) {
        double TF = CalculateTF.standard(invertedIndex, document);
        double IDF = CalculateIDF.standard(invertedIndex, documentsCount);
        return TF*IDF;
    }
}
