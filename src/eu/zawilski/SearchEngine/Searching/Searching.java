package eu.zawilski.SearchEngine.Searching;

import eu.zawilski.SearchEngine.Tuple;
import eu.zawilski.SearchEngine.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Searching {
    private ScoringStrategy scoringStrategy;

    public Searching(){
        this.scoringStrategy = new TFIDFScoring();
    }

    public List<String> searchSingleTerm(String term, Map<String, List<Tuple>> invertedIndex, List<Document> documentsData)
            throws IllegalArgumentException {
        List<Tuple> termInvertedIndex = invertedIndex.get(term);
        if (termInvertedIndex == null){
            throw new IllegalArgumentException("The term was not found in any document.\n");
        }
        List<SearchResult> searchResults = scoringStrategy.getSearchResults(termInvertedIndex, documentsData);
        return convertToStringList(searchResults);
    }

    private List<String> convertToStringList(List<SearchResult> searchResults){
        List<String> stringList = new ArrayList<>();
        for(SearchResult result : searchResults){
            if(result.getScore() > 0.0d){
                stringList.add(result.getDocumentName());
            }
        }
        return stringList;
    }

    private void printResults(List<SearchResult> searchResults){
        for(SearchResult result : searchResults){
            if(result.getScore() > 0){
                System.out.println(result);
            }
        }
    }
}
