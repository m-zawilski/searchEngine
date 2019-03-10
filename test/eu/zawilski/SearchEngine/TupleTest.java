package eu.zawilski.SearchEngine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TupleTest {
    private int documentNumber = 10, termPosition = 20;

    @Test
    void getDocumentNumber() {
        Tuple tuple = new Tuple(documentNumber,termPosition);
        assertEquals(documentNumber, tuple.getDocumentNumber());
    }

    @Test
    void getTermPosition() {
        Tuple tuple = new Tuple(documentNumber,termPosition);
        assertEquals(termPosition, tuple.getTermPosition());
    }

    @Test
    void throwsExceptionOnNegativeDocumentNumber(){
        assertThrows(IllegalArgumentException.class, () -> new Tuple(-5,termPosition));
    }

    @Test
    void throwsExceptionOnNegativeTermPosition(){
        assertThrows(IllegalArgumentException.class, () -> new Tuple(documentNumber,-5));
    }
}