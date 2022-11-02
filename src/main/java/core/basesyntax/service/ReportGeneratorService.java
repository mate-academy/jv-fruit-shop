package core.basesyntax.service;

import java.util.Map;

public interface ReportGeneratorService {
    String generateReport(Map<String, Integer> fruitStorageMap);
}
