package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> activities = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String value = reader.readLine();
            while (value != null) {
                activities.add(value);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
        return activities;
    }
}
