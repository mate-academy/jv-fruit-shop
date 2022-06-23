package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReader implements FileReader {
    @Override
    public List<String> readFile(String filePath) {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new java.io.FileReader(filePath))) {
            return bufferedReader.lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't find this file " + filePath, e);
        }
    }
}
