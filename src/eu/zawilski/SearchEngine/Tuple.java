package eu.zawilski.SearchEngine;

import java.util.Objects;

public class Tuple {
    private int fileNumber;
    private int termPosition;

    public Tuple(int fileNumber, int termPosition){
        if(fileNumber < 0 || termPosition < 0) {
            throw new IllegalArgumentException();
        }
        this.fileNumber = fileNumber;
        this.termPosition = termPosition;
    }

    public int getFileNumber() {
        return fileNumber;
    }

    public int getTermPosition() {
        return termPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return fileNumber == tuple.fileNumber &&
                termPosition == tuple.termPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileNumber, termPosition);
    }
}
