package core.basesyntax.service;

import java.util.Map;

public interface CsvFileWriterService {
    void writeDataToFileCsv(Map<String, String> lines, String filePath);
}
