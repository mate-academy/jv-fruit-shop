package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    @Override
    public String readFromFile(Path filePath) {
        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath.getFileName(), e);
        }
    }
}
