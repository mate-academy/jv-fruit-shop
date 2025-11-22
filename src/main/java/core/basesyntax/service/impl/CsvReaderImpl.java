package core.basesyntax.service.impl;

import core.basesyntax.service.CsvReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class CsvReaderImpl implements CsvReader {
    @Override
    public List<String> readAll(String path) {
        if (path == null) {
            throw new IllegalArgumentException("Path must not be null");
        }
        File file = new File(path);
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file: " + path, e);
        }
    }
}
