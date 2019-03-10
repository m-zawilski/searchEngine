package eu.zawilski.SearchEngine.Searching;

import eu.zawilski.SearchEngine.Document;
import eu.zawilski.SearchEngine.Tuple;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTFTest {

    @Test
    void standardCalculationResultsInPositiveValueWhenTermIsInDocument() {
        int documentNumber = 0, termCount = 20;
        String name = "test.txt";
        List<Tuple> termInvertedIndex = new ArrayList<>();
        Document document = new Document(documentNumber, name, termCount);
        termInvertedIndex.add(new Tuple(0,1));
        termInvertedIndex.add(new Tuple(1,2));
        termInvertedIndex.add(new Tuple(0,3));
        termInvertedIndex.add(new Tuple(0,10));

        double TF = CalculateTF.standard(termInvertedIndex,document);
        assertTrue(TF >= 0.0d);
    }

    @Test
    void standardCalculationResultsInZeroWhenTermIsNotInDocument() {
        int documentNumber = 2, termCount = 20;
        String name = "test.txt";
        List<Tuple> termInvertedIndex = new ArrayList<>();
        Document document = new Document(documentNumber, name, termCount);
        termInvertedIndex.add(new Tuple(0,1));
        termInvertedIndex.add(new Tuple(1,2));
        termInvertedIndex.add(new Tuple(0,3));
        termInvertedIndex.add(new Tuple(0,10));

        double TF = CalculateTF.standard(termInvertedIndex,document);
        assertEquals(0, TF);
    }
}