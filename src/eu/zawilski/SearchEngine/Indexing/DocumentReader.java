package eu.zawilski.SearchEngine.Indexing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class DocumentReader {
    String readDocument(String documentName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(documentName));
        for(String line; ; ){
            line = reader.readLine();
            if(line != null){
                line = line.trim();
                stringBuilder.append(line);
                if(!line.equals("")){
                    stringBuilder.append(" ");
                }
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }

}
