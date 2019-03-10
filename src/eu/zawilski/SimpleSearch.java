package eu.zawilski;

import eu.zawilski.ArgumentReader.ArgumentReader;
import eu.zawilski.SearchEngine.SearchEngine;

import java.util.Arrays;
import java.util.List;

public class SimpleSearch {
    public static void main(String[] args) {
        if (args.length < 2) {
            printMessageNotEnoughArguments();
            return;
        }

        String term = args[0];
        String[] documents = getDocumentsListFromArguments(args);

        SearchEngine searchEngine = new SearchEngine();
        List<String> searchResults = searchEngine.getResults(term, documents);
        if(searchResults != null){
            System.out.println(searchResults);
        }
    }

    private static String[] getDocumentsListFromArguments(String[] args){
        ArgumentReader argumentReader = new ArgumentReader();
        String[] documents = Arrays.copyOfRange(args, 1, args.length);
        return argumentReader.getArrayOfDocuments(documents);
    }

    private static void printMessageNotEnoughArguments(){
        System.out.println("Please insert a proper argument list.");
        System.out.println("First argument - term for searching.");
        System.out.println("Next arguments - documents/folders to search in.");
    }
}
