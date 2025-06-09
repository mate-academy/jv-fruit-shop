package core.basesyntax.service;

import java.math.BigDecimal;
import java.util.Map;

public interface WriterReportToCsv {
    void writeReport(Map<String, BigDecimal> storage, String outputFilePath);
}
