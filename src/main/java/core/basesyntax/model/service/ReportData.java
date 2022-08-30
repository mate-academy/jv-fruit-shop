package core.basesyntax.model.service;

import java.util.Map;
import java.util.Set;

public interface ReportData {
    String createDataReport(Set<Map.Entry<String, Integer>> entries);
}
