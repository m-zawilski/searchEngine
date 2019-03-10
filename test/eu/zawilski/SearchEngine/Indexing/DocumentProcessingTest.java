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

class DocumentProcessingTest {
    private DocumentProcessing documentProcessing;
    private String firstDocument = "test/tokenizeTestSample1.txt";
    private String secondDocument = "test/tokenizeTestSample2.txt";

    @BeforeEach
    void setUp() {
        documentProcessing = new DocumentProcessing();
    }

    @Test
    void addsDocumentsToDocumentsDataArray() {
        String[] documents = {firstDocument, secondDocument};

        List<Document> documentsData = new ArrayList<>();
        documentsData.add(new Document(0, firstDocument, 2));
        documentsData.add(new Document(1, secondDocument, 2));

        documentProcessing.processDocuments(documents);
        assertEquals(documentProcessing.getDocumentsData(), documentsData);
    }

    @Test
    void addsTermsToInvertedIndex() {
        String[] documents = {firstDocument, secondDocument};
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

        documentProcessing.processDocuments(documents);
        assertEquals(documentProcessing.getInvertedIndex(), invertedIndex);
    }

    @Test
    void getDocumentsData() {
        assertDoesNotThrow(() -> documentProcessing.getDocumentsData());
    }

    @Test
    void getInvertedIndex() {
        assertDoesNotThrow(() -> documentProcessing.getInvertedIndex());
    }
}