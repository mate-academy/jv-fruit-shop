package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderCsvImpl implements FileReaderCsv {
    @Override
    public List<String> getActivities(String pathToFile) {
        try {
            return Files.readAllLines(Path.of(pathToFile));
        } catch (IOException e) {
            throw new RuntimeException("can't read from file " + pathToFile, e);
        }
    }
}
