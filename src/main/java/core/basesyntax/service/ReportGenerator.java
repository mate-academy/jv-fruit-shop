package core.basesyntax.service;

import java.util.Map;

public interface ReportGenerator {
    String getReport(Map<String, Integer> storage);
}
