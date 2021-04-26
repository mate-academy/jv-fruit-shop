package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CsvReaderImpl implements CsvReader {
    private static final String ERROR_MESSAGE = "Can't read the file in this path";
    private static final int SKIP_TITLE = 1;

    @Override
    public List<String> readFile(String path) {
        try {
            return Files.readAllLines(Path.of(path))
                    .stream()
                    .skip(SKIP_TITLE)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(ERROR_MESSAGE + " " + path, e);
        }
    }
}