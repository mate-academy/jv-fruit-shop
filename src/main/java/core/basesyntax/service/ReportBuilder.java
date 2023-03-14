package core.basesyntax.service;

import java.util.Map;

public interface ReportBuilder {
    String buildReport(Map<String, Integer> data);
}
