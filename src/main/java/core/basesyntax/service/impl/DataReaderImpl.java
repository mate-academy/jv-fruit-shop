package core.basesyntax.service.impl;

import core.basesyntax.service.DataReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataReaderImpl implements DataReader {
    private static final String CSV_SPLITTER = ",";

    @Override
    public List<String> readData(String path) {
        return readLines(Path.of(path));
    }

    private List<String> readLines(Path path) {
        List<String> rows;
        try {
            rows = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + path);
        }
        return rows;
    }
}
