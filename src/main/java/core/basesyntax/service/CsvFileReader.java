package core.basesyntax.service;

import java.nio.file.Path;
import java.util.List;

public interface CsvFileReader {
    List<String[]> readDataFromFile(Path path);
}
