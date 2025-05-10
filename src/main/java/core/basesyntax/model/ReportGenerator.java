package core.basesyntax.model;

import java.util.Map;

public interface ReportGenerator {
    public String getReport(Map<String, Integer> storage);
}
