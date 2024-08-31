package core.basesyntax.fileoperations;

import java.util.Map;

public interface ReportGenerator {
    String getReport(Map<String, Integer> storage);
}
