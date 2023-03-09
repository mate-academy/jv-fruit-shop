package core.basesyntax.service;

import java.util.Map;

public interface ReportMakerService {
    String generateReportText(Map<String, Integer> info);
}
