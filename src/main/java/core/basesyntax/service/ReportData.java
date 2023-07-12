package core.basesyntax.service;

import java.util.Map;
import java.util.Set;

public interface ReportData {
    String createDataReport(Set<Map.Entry<String, Integer>> entries);
}
