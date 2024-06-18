package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    @Override
    public List<String> readFromFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}
