package core.basesyntax;

import java.util.Map;

public interface ReportGenerator {
    String getReport(Map<String, Integer> storage);
}
