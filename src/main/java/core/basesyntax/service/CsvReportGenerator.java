package core.basesyntax.service;

import java.util.Map;

public interface CsvReportGenerator {
    void generateCsvReport(Map<String, Integer> data);
}
