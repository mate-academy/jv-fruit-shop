package core.basesyntax.service;

import java.util.Map;

public interface ReportGenerator {
    String getReport();

    void generateReport(Map<String, Integer> inventory);
}
