package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvReader implements ReaderService {
    private static final int CSV_FORMAT_INDEX_OF_TITLE = 0;

    @Override
    public List<String> readFile(String filePath) {
        try {
            List<String> strings = Files.readAllLines(Path.of(filePath));
            strings.remove(CSV_FORMAT_INDEX_OF_TITLE);
            return strings;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file " + filePath, e);
        }
    }
}
