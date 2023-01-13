package core.basesyntax.service;

import java.nio.file.Path;

public interface CsvFileReaderService {
    String readFromFile(Path filePath);
}
