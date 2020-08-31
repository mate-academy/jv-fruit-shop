package core.basesyntax.service;

import java.util.Map;

public interface FileWriter {
    void createReportFile(Map<String, Integer> stockBalance, String filePath);
}