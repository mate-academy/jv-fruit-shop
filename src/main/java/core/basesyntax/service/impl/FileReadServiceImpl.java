package core.basesyntax.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReadServiceImpl implements core.basesyntax.service.FileReader {
    @Override
    public List<String> readData(String fileName) {
        List<String> dataFromFile = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String nextString = reader.readLine();
            while (nextString != null) {
                dataFromFile.add(nextString);
                nextString = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file: " + fileName, e);
        }
        return dataFromFile;
    }
}
