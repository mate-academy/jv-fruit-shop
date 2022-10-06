package core.basesyntax.fileservice.impl;

import core.basesyntax.fileservice.CsvFileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    @Override
    public List<String> readFromFile(String path) {
        List<String> readingLines = new ArrayList<>();
        try {
            readingLines = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't read info from file");
        }
        return readingLines;
    }
}
