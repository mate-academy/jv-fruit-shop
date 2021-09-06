package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> dataFromFile = new ArrayList<>();
        try (BufferedReader readFile = new BufferedReader(new FileReader(filePath))) {
            String lineText;
            while ((lineText = readFile.readLine()) != null) {
                dataFromFile.add(lineText);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + filePath);
        }
        return dataFromFile;
    }
}
