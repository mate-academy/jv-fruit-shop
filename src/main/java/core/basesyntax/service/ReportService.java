package core.basesyntax.service;

import java.util.Map;
import java.util.Set;

public interface ReportService {
    String createReport(Set<Map.Entry<String, Integer>> storage);
}
