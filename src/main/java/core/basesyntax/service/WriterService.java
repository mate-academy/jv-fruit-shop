package core.basesyntax.service;

import java.util.Map;

public interface WriterService {
    void writeReportToCsv(Map<String, Integer> report, String outputPath);
}
