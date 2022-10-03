package core.basesyntax.service;

import java.nio.file.Path;
import java.util.List;

public interface CsvFileReaderService {
    List<String> readFromFile(Path path);
}
