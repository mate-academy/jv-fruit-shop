package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface ReportService<T> {
    List<String> createReport(Map<String, Integer> map);
}
