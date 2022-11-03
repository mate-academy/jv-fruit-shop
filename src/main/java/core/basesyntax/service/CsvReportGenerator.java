package core.basesyntax.service;

import java.util.Map;

public interface CsvReportGenerator {
    byte[] generateCsvReport(Map<String, Integer> data);
}
