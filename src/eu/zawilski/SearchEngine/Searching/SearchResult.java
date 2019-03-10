package eu.zawilski.SearchEngine.Searching;

class SearchResult implements Comparable<SearchResult>{
    private String documentName;
    private double score;

    SearchResult(String documentName, double score){
        this.documentName = documentName;
        this.score = score;
    }

    double getScore() {
        return score;
    }

    String getDocumentName() {
        return documentName;
    }

    @Override
    public int compareTo(SearchResult o) {
        if (this.getScore() > o.getScore()) {
            return -1;
        }
        return 1;
    }

    @Override
    public String toString() {
        return (score > 0) ? "Document " + documentName + " has a score of " + score : "";
    }
}
