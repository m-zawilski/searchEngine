package eu.zawilski.SearchEngine.Searching;

import eu.zawilski.SearchEngine.Document;
import eu.zawilski.SearchEngine.Tuple;

import java.util.List;

final class CalculateTF {

    static double standard(List<Tuple> invertedIndex, Document document){
        double frequencyCounter = 0.0d;
        for(Tuple tuple : invertedIndex){
            if(tuple.getDocumentNumber() == document.getNumber()){
                frequencyCounter++;
            }
        }
        return (frequencyCounter != 0.0d) ? frequencyCounter/document.getTermCount() : 0.0d;
    }
}
