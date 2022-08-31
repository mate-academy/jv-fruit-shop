package core.basesyntax.service;

import java.util.Map;
import java.util.Set;

public interface ReporterService {
    String createReport(Set<Map.Entry<String, Integer>> data);
}
