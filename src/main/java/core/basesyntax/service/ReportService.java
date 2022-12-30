package core.basesyntax.service;

import java.util.Map;

public interface ReportService {
    String getReport(StringBuilder reportBuilder, Map<String, Integer> fruitMap);
}
