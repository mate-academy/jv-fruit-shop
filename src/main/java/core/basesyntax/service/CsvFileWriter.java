package core.basesyntax.service;

import java.util.Map;

public interface CsvFileWriter {
    void write(String pathToFile, Map<String, Integer> report);
}
