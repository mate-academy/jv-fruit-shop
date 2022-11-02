package core.basesyntax.service;

import java.util.Map;

public interface CsvReportGenerator {
    void generateReport(Map<String, Integer> data);
}
