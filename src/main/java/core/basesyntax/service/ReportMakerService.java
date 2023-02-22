package core.basesyntax.service;

import java.util.Map;

public interface ReportMakerService {
    void generateReport(Map<String, Integer> fruitsMap, String toFile);
}
