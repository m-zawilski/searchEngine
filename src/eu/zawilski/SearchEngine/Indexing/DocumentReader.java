package eu.zawilski.SearchEngine.Indexing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class DocumentReader {
    String readDocument(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
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
