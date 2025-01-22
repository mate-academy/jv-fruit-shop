package core.basesyntax.model;

import java.util.Map;

public interface ReportGenerator {
    String getReport(Map<String, Integer> storage);
}
