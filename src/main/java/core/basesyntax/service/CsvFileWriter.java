package core.basesyntax.service;

import java.util.List;

public interface CsvFileWriter {
    void writeToFile(String filePath, List<String> fruits);
}
