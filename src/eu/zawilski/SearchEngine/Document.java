package eu.zawilski.SearchEngine;

import java.util.Objects;

public class Document {
    private int number;
    private String name;
    private int termCount;

    public Document(int number, String name, int termCount){
        this.number = number;
        this.name = name;
        this.termCount = termCount;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getTermCount() {
        return termCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return number == document.number &&
                termCount == document.termCount &&
                Objects.equals(name, document.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, termCount);
    }
}
