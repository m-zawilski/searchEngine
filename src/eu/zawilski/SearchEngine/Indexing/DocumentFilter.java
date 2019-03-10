package eu.zawilski.SearchEngine.Indexing;

import java.util.Arrays;

class DocumentFilter {
    private char[] punctuationMarks = { '.', ',', ':', '"', '\'',
                                        '?', '!', ';', '(', ')',
                                        '{', '}', '[', ']', '-'};

    String basicFiltering(String input){
        input = input.toLowerCase();
        return removePunctuation(input);
    }

    private String removePunctuation(String input){
        StringBuilder stringBuilder = new StringBuilder();
        boolean isPunctuation = false;
        for(char character : input.toCharArray()){
            for(char mark : punctuationMarks){
                if(character == mark) {
                    isPunctuation = true;
                    break;
                }
            }
            if(!isPunctuation) {
                stringBuilder.append(character);
            }
            isPunctuation = false;
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentFilter that = (DocumentFilter) o;
        return Arrays.equals(punctuationMarks, that.punctuationMarks);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(punctuationMarks);
    }
}
