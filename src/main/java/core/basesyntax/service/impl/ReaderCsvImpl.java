package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderCsvImpl implements Reader {
    private static final String INPUT_FILE_PATH = "src/main/resources/input_database.csv";

    @Override
    public List<String> read() {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(INPUT_FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + INPUT_FILE_PATH, e);
        }
        return lines;
    }
}
