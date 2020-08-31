package core.basesyntax.service;

import java.util.Map;

public interface FileWriter {
    void createReportFile(Map<String, Long> stockBalance, String filePath);
}