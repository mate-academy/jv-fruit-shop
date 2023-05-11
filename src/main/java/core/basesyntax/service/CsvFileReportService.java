package core.basesyntax.service;

import java.util.Map;

public interface CsvFileReportService {
    String createReport(Map<String, Integer> products);
}
