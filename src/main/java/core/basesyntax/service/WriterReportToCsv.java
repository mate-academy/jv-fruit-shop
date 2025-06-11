package core.basesyntax.service;

import java.util.Map;

public interface WriterReportToCsv {
    void writeReport(Map<String, Integer> storage, String outputFilePath);
}
