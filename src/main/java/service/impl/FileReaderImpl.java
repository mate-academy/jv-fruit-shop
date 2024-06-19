package service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.FileReader;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String fileName) {
        List<String> listOfLines = new ArrayList<>();
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String value;
            while ((value = reader.readLine()) != null) {
                listOfLines.add(value);
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read the file " + file.getPath(), e);
        }
        return listOfLines;
    }
}
