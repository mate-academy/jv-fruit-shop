package core.basesyntax.service;

import java.util.Map;

public interface CsvFileWriter {
    void createReportFile(Map<String, Long> storageBalance, String filePath);
}
