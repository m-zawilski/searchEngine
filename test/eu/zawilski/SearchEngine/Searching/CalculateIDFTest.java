package eu.zawilski.SearchEngine.Searching;

import eu.zawilski.SearchEngine.Tuple;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateIDFTest {

    @Test
    void standardCalculationResultsInPositiveValueWhenTermNotEverywhere() {
        List<Tuple> termInvertedIndex = new ArrayList<>();
        int documentsCount = 4;
        termInvertedIndex.add(new Tuple(0,1));
        termInvertedIndex.add(new Tuple(1,2));
        termInvertedIndex.add(new Tuple(0,3));
        termInvertedIndex.add(new Tuple(0,10));

        double IDF = CalculateIDF.standard(termInvertedIndex,documentsCount);
        assertTrue(IDF >= 0.0d);
    }

    @Test
    void standardCalculationResultsInZeroWhenTermEverywhere() {
        List<Tuple> termInvertedIndex = new ArrayList<>();
        int documentsCount = 4;
        termInvertedIndex.add(new Tuple(0,1));
        termInvertedIndex.add(new Tuple(1,2));
        termInvertedIndex.add(new Tuple(2,3));
        termInvertedIndex.add(new Tuple(3,10));

        double IDF = CalculateIDF.standard(termInvertedIndex,documentsCount);
        assertEquals(0.0d, IDF);
    }
}