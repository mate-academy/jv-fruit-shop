package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReader implements FileReader {
    @Override
    public List<String> readData(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path))) {
            return bufferedReader
                    .lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Invalid file or path to it");
        }
    }
}
