package core.basesyntax.impl;

import core.basesyntax.service.CsvFileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    private static final int HEADER_ROW = 0;

    @Override
    public List<String> readLines(String source) {
        try {
            List<String> lines = Files.readAllLines(Path.of(source));
            lines.remove(HEADER_ROW);
            return lines;
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file: " + source,e);
        }
    }
}
