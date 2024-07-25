package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String generateReport(Map<String, Integer> fruitsQuantityAfterDay) {
        StringBuilder report = new StringBuilder();
        report.append(HEADER);
        for (Map.Entry<String, Integer> entry : fruitsQuantityAfterDay.entrySet()) {
            report.append("\n");
            report.append(entry.getKey());
            report.append(",");
            report.append(entry.getValue());
        }
        return report.toString();
    }
}
