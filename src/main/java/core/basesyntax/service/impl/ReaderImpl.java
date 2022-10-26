package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderImpl implements Reader {
    private static final String FILE_EXAMPLE_CSV = "inputFileExample.csv";

    @Override
    public List<String> readFromFile() {
        try {
            return Files.readAllLines(Path.of("src/main/java/resources/inputFileExample.csv"));
        } catch (IOException e) {
            throw new RuntimeException("Can't get the info from the file " + FILE_EXAMPLE_CSV, e);
        }
    }
}
