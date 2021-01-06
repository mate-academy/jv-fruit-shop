package core.basesyntax.service;

import java.util.Map;

public interface FileWriter {
    void writeReportToFile(Map<String, Long> report, String pathToFile);
}
