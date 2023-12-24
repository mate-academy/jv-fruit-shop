package core.basesyntax.db;

import java.util.Map;

public interface ReportFileWriter {
    void writeToFile(Map<String, Integer> fruits, String filePath);
}
