package core.basesyntax.service;

import java.util.Map;

public interface CsvWriterService {
    void writeToReport(String path, Map<String, Integer> report);
}
