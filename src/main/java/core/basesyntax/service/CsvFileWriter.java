package core.basesyntax.service;

import java.util.Map;

public interface CsvFileWriter {
    void write(Map<String, Integer> fruitsAtStorageMap, String pathname);
}
