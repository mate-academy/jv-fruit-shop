package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class MyFileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new RuntimeException("File not found: " + filePath);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
    }
}
