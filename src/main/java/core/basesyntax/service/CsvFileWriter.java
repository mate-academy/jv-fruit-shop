package core.basesyntax.service;

import java.util.Map;

public interface CsvFileWriter {
    void reportFile(Map<String, Long> balance, String filePath);
}
