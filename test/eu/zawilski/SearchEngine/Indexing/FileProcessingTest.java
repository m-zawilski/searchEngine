package eu.zawilski.SearchEngine.Indexing;

import eu.zawilski.SearchEngine.Document;
import eu.zawilski.SearchEngine.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FileProcessingTest {
    private FileProcessing fileProcessing;

    @BeforeEach
    void setUp() {
        fileProcessing = new FileProcessing();
    }

    @Test
    void addsDocumentsToDocumentsDataArray() {
        String[] documents = {"test/tokenizeTestSample1.txt", "test/tokenizeTestSample2.txt"};

        List<Document> documentsData = new ArrayList<>();
        documentsData.add(new Document(0, "test/tokenizeTestSample1.txt", 2));
        documentsData.add(new Document(1, "test/tokenizeTestSample2.txt", 2));

        fileProcessing.processDocuments(documents);
        assertEquals(fileProcessing.getDocumentsData(), documentsData);
    }

    @Test
    void addsTermsToInvertedIndex() {
        String[] documents = {"test/tokenizeTestSample1.txt", "test/tokenizeTestSample2.txt"};
        Map<String, List<Tuple>> invertedIndex = new HashMap<>();

        List<Tuple> lazy = new ArrayList<>();
        lazy.add(new Tuple(0,0));
        lazy.add(new Tuple(1,0));
        invertedIndex.put("lazy", lazy);

        List<Tuple> dog = new ArrayList<>();
        dog.add(new Tuple(0,1));
        invertedIndex.put("dog", dog);

        List<Tuple> fox = new ArrayList<>();
        fox.add(new Tuple(1,1));
        invertedIndex.put("fox", fox);

        fileProcessing.processDocuments(documents);
        assertEquals(fileProcessing.getInvertedIndex(), invertedIndex);
    }

    @Test
    void getDocumentsData() {
        assertDoesNotThrow(() -> fileProcessing.getDocumentsData());
    }

    @Test
    void getInvertedIndex() {
        assertDoesNotThrow(() -> fileProcessing.getInvertedIndex());
    }
}