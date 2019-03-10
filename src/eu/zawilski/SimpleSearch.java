package eu.zawilski;

import eu.zawilski.SearchEngine.SearchEngine;

import java.util.List;

public class SimpleSearch {
    public static void main(String[] args) {
        if (args.length < 2) {
            printMessageNotEnoughArguments();
            return;
        }

        SearchEngine searchEngine = new SearchEngine();
        List<String> searchResults = searchEngine.getResults(args);
        if(searchResults != null){
            System.out.println(searchResults);
        }
    }

    private static void printMessageNotEnoughArguments(){
        System.out.println("Please insert a proper argument list.");
        System.out.println("First argument - term for searching.");
        System.out.println("Next arguments - documents to search in.");
    }
}
