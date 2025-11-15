package core.basesyntax.service;

import java.util.Map;

public interface ReportGenerator {
    void generateReport(Map<String, Integer> storage, String filePath);
}
