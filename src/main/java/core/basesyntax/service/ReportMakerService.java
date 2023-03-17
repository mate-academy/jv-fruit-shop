package core.basesyntax.service;

import java.util.Map;

public interface ReportMakerService {
    public String generateReport(Map<String, Integer> calculations);
}
