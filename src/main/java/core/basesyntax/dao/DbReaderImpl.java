package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DbReaderImpl implements DbReader {
    private static final String FILENAME = "inputData.csv";

    @Override
    public List<String> read() {
        List<String> dataFromDb;
        try {
            dataFromDb = Files.readAllLines(Path.of(FILENAME));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + FILENAME);
        }
        return dataFromDb;
    }
}
