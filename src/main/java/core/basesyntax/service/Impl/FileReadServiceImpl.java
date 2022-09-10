package core.basesyntax.service.Impl;

import core.basesyntax.service.FileReadService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReadServiceImpl implements FileReadService {
    @Override
    public List<String> readDataFromFile(String fileName) {
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
