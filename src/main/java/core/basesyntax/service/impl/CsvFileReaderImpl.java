package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class CsvFileReaderImpl implements CsvFileReader {
    @Override
    public String read(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName, e);
        }
    }
}
