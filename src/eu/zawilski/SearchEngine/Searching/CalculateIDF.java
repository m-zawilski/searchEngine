package eu.zawilski.SearchEngine.Searching;

import eu.zawilski.SearchEngine.Tuple;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class CalculateIDF {

    static double standard(List<Tuple> invertedIndex, int documentsCount){
        Set<Integer> inverseFrequency = new HashSet<>();
        for(Tuple tuple : invertedIndex){
            inverseFrequency.add(tuple.getFileNumber());
        }
        double inverseFrequencyCounter = inverseFrequency.size();
        return (inverseFrequencyCounter != 0.0d) ? Math.log(documentsCount/inverseFrequencyCounter) : 0.0d;
    }
}
