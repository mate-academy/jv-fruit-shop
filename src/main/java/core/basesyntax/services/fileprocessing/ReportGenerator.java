package core.basesyntax.services.fileprocessing;

import java.util.Map;
import java.util.Set;

public interface ReportGenerator {
    StringBuilder generateReport(Set<Map.Entry<String, Integer>> fruitEntrySet);
}
