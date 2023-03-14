package core.basesyntax.services;

import java.nio.file.Path;
import java.util.List;

public interface CsvFileReaderService {
    List<String> readFromFile(Path filePath);
}
