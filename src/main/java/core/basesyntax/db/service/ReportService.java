package core.basesyntax.db.service;

import java.util.Map;

public interface ReportService {
    Map<String, Integer> generate(Map<String, Integer> report);
}
