package core.basesyntax.service.impl;

import core.basesyntax.exception.CsvFileException;
import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReader implements FileReader {
    private final Path source;

    public CsvFileReader(Path source) {
        this.source = source;
    }

    @Override
    public List<String> read() {
        try {
            return Files.readAllLines(source);
        } catch (IOException e) {
            throw new CsvFileException("Can't read data from csv file: " + source, e);
        }
    }
}
