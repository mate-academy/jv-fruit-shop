package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String path) {
        File file = new File(path);
        List<String> data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String lineFromFile = bufferedReader.readLine();
            while (lineFromFile != null) {
                data.add(lineFromFile);
                lineFromFile = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while reading the file: " + e);
        }
        return data;
    }
}
