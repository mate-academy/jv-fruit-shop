package core.basesyntax;

import java.util.Map;

public interface ReportGenerator {
    String generateReport(Map<String, Integer> inventory);
}
