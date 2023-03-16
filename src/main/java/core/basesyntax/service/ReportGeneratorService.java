package core.basesyntax.service;

import java.util.Map;

public interface ReportGeneratorService {
    void generateReport(Map<String, Integer> storage, String path);
}
