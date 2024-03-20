package core.basesyntax.service.impl;

import core.basesyntax.exception.FileReadingFailureException;
import core.basesyntax.service.DataReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvReader implements DataReader {
    private static final String READING_FAILURE_MESSAGE = "Failed to read from the file";

    @Override
    public List<String> read(String fileName) {
        try {
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new FileReadingFailureException(READING_FAILURE_MESSAGE + fileName, e);
        }
    }
}
