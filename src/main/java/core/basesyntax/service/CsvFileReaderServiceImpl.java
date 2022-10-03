package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    @Override
    public List<String> readFromFile(Path path) {
        List<String> readingLines = new ArrayList<>();
        try {
            readingLines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read info from file");
        }
        return readingLines;
    }
}
