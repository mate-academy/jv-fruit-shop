package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {
    @Override
    public List<String> readDataFromFile(String path) {
        try {
            return Files.lines(Path.of(path)).skip(1).toList();
        } catch (IOException e) {
            throw new RuntimeException("Error read file", e );
        }

    }
}
