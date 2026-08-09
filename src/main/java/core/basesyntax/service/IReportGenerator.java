package core.basesyntax.service;

import java.util.Map;

public interface IReportGenerator {
    String generateReport(Map<String, Integer> storage);
}
