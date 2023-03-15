package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface GenerateReport {
    String generateReportString(Map<String, Integer> fruits);

    void generateReport(List<String[]> fruits);
}
