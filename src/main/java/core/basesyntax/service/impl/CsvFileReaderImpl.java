package core.basesyntax.service.impl;

import core.basesyntax.service.reader.CsvFileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {
    @Override
    public List<String> readDataFromFile(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Cannot read data from: " + path
                    + ", check if the filename is correct", e);
        }
    }
}
