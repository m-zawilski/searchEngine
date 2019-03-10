package eu.zawilski.SearchEngine.Indexing;

import eu.zawilski.SearchEngine.Tuple;

import java.io.IOException;
import java.util.*;

import eu.zawilski.SearchEngine.Document;

public class FileProcessing {
    private List<Document> documentsData = new ArrayList<>();
    private Map<String, List<Tuple>> invertedIndex = new HashMap<>();

    public void processDocuments(String[] documents) {
        Indexing indexing = new Indexing();
        invertedIndex = indexing.createDocumentsMetadata(documents);
    }

    public List<Document> getDocumentsData() {
        return documentsData;
    }

    public Map<String, List<Tuple>> getInvertedIndex() {
        return invertedIndex;
    }

    private void addDocumentToDocumentsList(int documentNumber, String name, int termsCount) {
        Document document = new Document(documentNumber, name, termsCount);
        documentsData.add(document);
    }

    private class Indexing {
        private DocumentReader reader = new DocumentReader();
        private DocumentFilter filter = new DocumentFilter();
        private Tokenizer tokenizer = new Tokenizer();

        Map<String, List<Tuple>> createDocumentsMetadata(String[] documents) {
            for (int i = 0; i < documents.length; i++) {
                try {
                    addDocumentMetadata(documents[i], i);
                } catch (IOException e) {
                    handleWrongFileException(documents[i]);
                }
            }
            return invertedIndex;
        }

        private void handleWrongFileException(String document) {
            System.out.println("Document omitted. File " + document + " was not found.");
        }

        private void addDocumentMetadata(String document, int documentNumber) throws IOException {
            List<String> documentTerms = readAndTokenizeDocument(document);
            addDocumentTermsToInvertedIndex(documentTerms, documentNumber);
            addDocumentToDocumentsList(documentNumber, document, documentTerms.size());
        }

        private List<String> readAndTokenizeDocument(String document) throws IOException {
            String input = reader.readDocument(document);
            String filteredInput = filter.basicFiltering(input);
            return tokenizer.tokenize(filteredInput);
        }

        private void addDocumentTermsToInvertedIndex(List<String> documentTerms, int documentNumber) {
            int currentPosition = 0;
            for (String term : documentTerms) {
                List<Tuple> termPositions = invertedIndex.get(term);
                if (termPositions == null) {
                    termPositions = new LinkedList<>();
                    invertedIndex.put(term, termPositions);
                }
                termPositions.add(new Tuple(documentNumber, currentPosition));
                currentPosition++;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileProcessing that = (FileProcessing) o;
        return Objects.equals(documentsData, that.documentsData) &&
                Objects.equals(invertedIndex, that.invertedIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentsData, invertedIndex);
    }
}
