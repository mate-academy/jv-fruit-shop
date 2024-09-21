package core.basesyntax.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
    }
}

