package core.basesyntax.service;

import java.util.List;

public interface CsvReader {
    List<String> read(String filePath);
}
