package core.basesyntax.service;

import java.util.Map;

public interface ReportService {
    void generateReport(Map<String, Integer> fruits, String fileName);
}
