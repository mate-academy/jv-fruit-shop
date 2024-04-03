package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReader {

    public ArrayList<String> read(String fileName) {
        ArrayList<String> textFromFile = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(fileName))) {
            bufferedReader.readLine(); //reading first line because it contains fields names
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                textFromFile.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + fileName, e);
        }
        return textFromFile;
    }
}
