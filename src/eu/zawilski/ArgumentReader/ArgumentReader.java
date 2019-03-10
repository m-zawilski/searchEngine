package eu.zawilski.ArgumentReader;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ArgumentReader {
    private Set<String> setOfDocuments = new HashSet<>();

    public String[] getArrayOfDocuments(String[] args){
        File[] files = getInitialFilesList(args);
        addDocumentsArrayToSet(files);
        return changeSetToArray();
    }

    private String[] changeSetToArray(){
        String[] array = new String[setOfDocuments.size()];
        int i = 0;
        for(String document : setOfDocuments){
            array[i] = document;
            i++;
        }
        return array;
    }

    private File[] getInitialFilesList(String[] args){
        File[] files = new File[args.length];
        for(int i = 0; i<args.length; i++){
            files[i] = new File(args[i]);
        }
        return files;
    }

    private void addDocumentsArrayToSet(File[] files){
        for(File file : files){
            if(file.isDirectory()){
                File[] subFiles = file.listFiles();
                if(subFiles != null){
                    addDocumentsArrayToSet(subFiles);
                }
            } else if (file.isFile()) {
                setOfDocuments.add(file.getPath());
            }
        }
    }
}
