package eu.zawilski.SearchEngine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TupleTest {
    private int fileNumber = 10, termPosition = 20;

    @Test
    void getFileNumber() {
        Tuple tuple = new Tuple(fileNumber,termPosition);
        assertEquals(fileNumber, tuple.getFileNumber());
    }

    @Test
    void getTermPosition() {
        Tuple tuple = new Tuple(fileNumber,termPosition);
        assertEquals(termPosition, tuple.getTermPosition());
    }

    @Test
    void throwsExceptionOnNegativeFileNumber(){
        assertThrows(IllegalArgumentException.class, () -> new Tuple(-5,termPosition));
    }

    @Test
    void throwsExceptionOnNegativeTermPosition(){
        assertThrows(IllegalArgumentException.class, () -> new Tuple(fileNumber,-5));
    }
}