package core.basesyntax.service;

import java.util.Map;

public interface ReportMaker {
    public String generateReport(Map<String, Integer> calculations);
}
