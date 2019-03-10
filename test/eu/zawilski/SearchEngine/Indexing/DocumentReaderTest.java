package eu.zawilski.SearchEngine.Indexing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DocumentReaderTest {
    private DocumentReader documentReader;

    @BeforeEach
    void setUp() {
        documentReader = new DocumentReader();
    }

    @Test
    void readAllDocumentLines() throws IOException {
        String result = "the brown fox jumped over the brown dog the brown fox jumped over the brown dog the brown fox jumped over the brown dog ";
        assertEquals(result, documentReader.readDocument("test/readerTestSample.txt"));
    }

    @Test
    void throwsExceptionWhenFileNotFound(){
        assertThrows(IOException.class, () -> documentReader.readDocument("test/notExisting.txt"));
    }
}