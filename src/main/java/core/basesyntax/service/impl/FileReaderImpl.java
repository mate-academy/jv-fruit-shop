package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> data;
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(fileName))) {
            data = bufferedReader.lines()
                    .skip(1)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read from file: " + fileName, e);
        }
        return data;
    }
}
