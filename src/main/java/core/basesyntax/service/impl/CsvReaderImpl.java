package core.basesyntax.service.impl;

import core.basesyntax.service.CsvReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvReaderImpl implements CsvReader {
    @Override
    public List<String> readLines(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines().toList();
        } catch (IOException e) {
            throw new RuntimeException("An exception occurred while reading a file = ["
                    + fileName + "]", e);
        }
    }
}
