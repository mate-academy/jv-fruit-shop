package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromCsvFile(String path) {
        List<String> data;
        try {
            data = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + path);
        }
        return data;
    }
}
