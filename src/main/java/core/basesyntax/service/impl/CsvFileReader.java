package core.basesyntax.service.impl;

import core.basesyntax.exception.CsvFileException;
import core.basesyntax.service.FileReader;
import core.basesyntax.util.validator.PathValidator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReader implements FileReader {
    @Override
    public List<String> read(Path source) {
        PathValidator.validatePathForReading(source);
        try {
            return Files.readAllLines(source);
        } catch (IOException e) {
            throw new CsvFileException("Can't read data from csv file: " + source, e);
        }
    }
}
