package core.basesyntax.service.impl;

import core.basesyntax.service.DataReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataReaderCsvImpl implements DataReader {
    private static final String DATA_PATH = "src/main/java/resources/fruits.csv";

    @Override
    public List<String> read() {
        try {
            return Files.readAllLines(Path.of(DATA_PATH));
        } catch (IOException e) {
            throw new RuntimeException("can't read data from file: " + DATA_PATH);
        }
    }
}
