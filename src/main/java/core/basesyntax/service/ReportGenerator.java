package core.basesyntax.service;

import java.util.Map;

public interface ReportGenerator {
    String generateReport(Map<String, Integer> inventory);
}
