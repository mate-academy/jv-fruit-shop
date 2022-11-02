package core.basesyntax.service;

import java.util.Map;

public interface ReportGenerator {
    void generateCsvReport(Map<String, Integer> data);
}
