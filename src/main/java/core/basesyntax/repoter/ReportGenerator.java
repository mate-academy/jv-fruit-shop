package core.basesyntax.repoter;

import java.util.Map;

public interface ReportGenerator {
    String getReport(Map<String, Integer> repository);
}
