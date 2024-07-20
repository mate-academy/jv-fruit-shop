package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String generateReport(Map<String, Integer> fruitsQuantityAfterDay) {
        StringBuilder report = new StringBuilder();
        for (Map.Entry<String, Integer> entry : fruitsQuantityAfterDay.entrySet()) {
            report.append(entry.getKey());
            report.append(" = ");
            report.append(entry.getValue());
            report.append("\n");
        }
        return report.toString();
    }
}
