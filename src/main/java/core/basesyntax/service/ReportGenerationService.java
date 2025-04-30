package core.basesyntax.service;

import java.util.Map;

public interface ReportGenerationService {
    String generateReport(Map<String, Integer> fruitQuantities);
}
