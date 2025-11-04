package core.basesyntax.services;

import java.util.Map;

public interface ReportGenerator {
    String getReport(Map<String, Integer> transactions);
}
