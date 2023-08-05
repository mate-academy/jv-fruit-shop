package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface ReportService<T> {
    List<String> report(Map<String, Integer> map);
}
