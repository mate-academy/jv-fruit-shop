package core.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderService implements FileReaderService {
    private final List<String> dataFromFile = new ArrayList<>();

    @Override
    public List<String> read(String fileName) {
        try (BufferedReader readFile = new BufferedReader(new FileReader(fileName))) {
            readFile.readLine();
            String lineText;
            while ((lineText = readFile.readLine()) != null) {
                dataFromFile.add(lineText);
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found - " + fileName, e);
        }
        return dataFromFile;
    }
}
