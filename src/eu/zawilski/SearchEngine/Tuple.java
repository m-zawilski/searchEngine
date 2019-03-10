package eu.zawilski.SearchEngine;

import java.util.Objects;

public class Tuple {
    private int documentNumber;
    private int termPosition;

    public Tuple(int documentNumber, int termPosition){
        if(documentNumber < 0 || termPosition < 0) {
            throw new IllegalArgumentException();
        }
        this.documentNumber = documentNumber;
        this.termPosition = termPosition;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public int getTermPosition() {
        return termPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return documentNumber == tuple.documentNumber &&
                termPosition == tuple.termPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentNumber, termPosition);
    }
}
