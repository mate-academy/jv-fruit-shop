package core.basesyntax.service.impl;

import core.basesyntax.exception.CsvFileException;
import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvReader implements FileReader {
    @Override
    public List<String> readFromFile(Path readPath) {
        try {
            return Files.readAllLines(readPath);
        } catch (IOException e) {
            throw new CsvFileException("Can't read from csv file " + readPath, e);
        }
    }
}
