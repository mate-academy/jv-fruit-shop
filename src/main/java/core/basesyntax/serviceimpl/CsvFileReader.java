package core.basesyntax.serviceimpl;

import core.basesyntax.service.DataReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReader implements DataReader {
    private static final String CANNOT_READ_FILE_MESSAGE = "Cannot read the file at ";

    @Override
    public List<String> readFile(String pathToFile) {
        try {
            return Files.readAllLines(Path.of(pathToFile));
        } catch (IOException e) {
            throw new RuntimeException(CANNOT_READ_FILE_MESSAGE + pathToFile, e);
        }
    }
}
