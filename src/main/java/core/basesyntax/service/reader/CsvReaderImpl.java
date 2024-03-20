package core.basesyntax.service.reader;

import core.basesyntax.exception.CsvReaderException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvReaderImpl implements CsvReader {
    @Override
    public List<String> readFile(Path fileName) {
        try {
            return Files.readAllLines(fileName);
        } catch (IOException e) {
            throw new CsvReaderException("Error reading file: " + fileName, e);
        }
    }
}
