package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {
    @Override
    public List<String> read(String pathToFile) {
        try {
            return Files.readAllLines(Path.of(pathToFile));
        } catch (IOException e) {
            throw new RuntimeException("can't read from file " + pathToFile, e);
        }
    }
}
