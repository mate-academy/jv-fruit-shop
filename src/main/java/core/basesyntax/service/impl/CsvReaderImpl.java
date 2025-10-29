package core.basesyntax.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvReaderImpl implements CsvReader {

    @Override
    public List<String> read(String pathFile) {
        try {
            return Files.readAllLines(Paths.get(pathFile));
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file: " + pathFile, e);
        }
    }
}
