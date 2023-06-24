package core.basesyntax.service;

import java.util.Map;

public interface ReportGeneratorService {
    public String generateReportText(Map<String, Integer> storage);
}
