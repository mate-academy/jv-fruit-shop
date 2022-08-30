package core.basesyntax.service;

import java.util.List;

public interface CsvReader {
    List<String> readFromFile(String filePath);
}
