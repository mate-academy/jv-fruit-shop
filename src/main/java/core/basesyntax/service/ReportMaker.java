package core.basesyntax.service;

import java.util.Map;

public interface ReportMaker {
    String makingReport(Map<String, Long> totalAmount);
}
