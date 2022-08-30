package core.basesyntax.services;

import java.util.List;

public interface CsvFileReader {
    List<String> readData(String filePath);
}
